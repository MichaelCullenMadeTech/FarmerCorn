<template>
  <div class="hello">

    <transition name="fade" mode="out-in">
    <div class="form-area">
      <b-progress :value="section" :max="2" class="mb-3" variant="info"></b-progress>
      <div class="form-input bags" v-if="section==0">
        Number of bags of Corn:
        <b-form-input class="bags-input" v-model="numberOfBags" placeholder="How many bags"></b-form-input>
        <div class="bags-btns">
          <b-button class="bags-btn bags-btn__increment" id="bags-increase"  variant="info" @click="incrementBagCounter">+</b-button>
          <b-button class="bags-btn" variant="info" id="bags-decrease" @click="decrementBagCounter">-</b-button>
        </div>
        Number of Geese:
        <b-form-input class="bags-input" v-model="numberOfGeese" placeholder="How many geese"></b-form-input>
        <div class="bags-btns">
          <b-button class="bags-btn bags-btn__increment" id="geese-increase" variant="info" @click="incrementGeeseCounter">+</b-button>
          <b-button class="bags-btn" id="geese-decrease" variant="info" @click="decrementGeeseCounter">-</b-button>
        </div>
      </div>

      <div class="form-input trip" id="trip-form" v-if="section==1">
        <div class="trip">
          How much is a single trip:
          <div class="trip-input">
            <currency-input 
              currency="GBP" 
              class="trip-currency" 
              v-model="tripCurrency" 
              placeholder="How much is a single trip?"/>
          </div>
        </div>
        <div class="meat">
          How much is croc meat today:
          <div class="meat-input">
            <currency-input 
              currency="GBP" 
              class="trip-currency" 
              v-model="crocMeatPrice" 
              placeholder="How much is a single trip?"/>
          </div>
        </div>
      </div>

      <div class="form-input quote" id="quote-form" v-if="section==2">
        <div class="ferry">
          Cost of ferry:
          <div class="trip-input">
            <currency-input 
              currency="GBP" 
              class="trip-currency" 
              v-model="quote"
              placeholder="Cost of ferry?"/>
          </div>
        </div>
        <div class="meat">
          Cost of meat:
          <div class="trip-input">
            <currency-input 
              currency="GBP" 
              class="trip-currency" 
              v-model="meatCost"
              placeholder="Cost of meat?"/>
          </div>
        </div>
      </div>
      <div class="directions"> 
        <div class="directions-content" id="directions-content" v-if="directions">
              {{ directions }}
        </div>
      </div>
      <div class="validation"> 
        <div class="validation-message" id="validation-message" v-if="!valid">
          Not possible - They'll eat each other!
        </div>
        <div class="validation-gif" id="validation-gif" v-if="!valid">
          <div style="width:16rem;height:10rem;"><iframe src="https://giphy.com/embed/7wq5iawqr1IZy" width="100%" height="100%" frameBorder="0" class="giphy-embed" allowFullScreen></iframe></div>
        </div>
        <div class="validation-gif" id="validation-gif" v-if="directions">
          <img class="header-img" alt="Vue logo" src="../assets/Yewwww.png">
        </div>
      </div>
      <b-button class="next-btn" id="next-btn" variant="success" @click="changeSection" v-if="section<=1">Next</b-button>
      <b-button class="next-btn" id="calc-btn" variant="success" @click="calculate" v-if="section>1">Calculate</b-button>
    </div>
    </transition>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data() {
    return {
      section: 0,
      numberOfBags: 0,
      numberOfGeese: 0,
      tripCurrency: 0.25,
      crocMeatPrice: 0.05,
      quote: 0,
      priceOfTrip: 0,
      valid: true,
      directions: null,
      meatCost: 0
    }
  },
  methods: {
      incrementBagCounter: function() {
          this.numberOfBags += 1;
      },
      decrementBagCounter: function() {
          if (this.numberOfBags >0) this.numberOfBags -= 1;
      },
      incrementGeeseCounter: function() {
          this.numberOfGeese += 1;
      },
      decrementGeeseCounter: function() {
          if (this.numberOfGeese >0) this.numberOfGeese -= 1;
      },
      changeSection: function() {
        if( this.numberOfBags > 1 && this.numberOfGeese > 1 || this.numberOfBags == 1 && this.numberOfGeese > 2 || this.numberOfBags > 2 && this.numberOfGeese == 1 ) {
          this.valid = false;
        } else {
          this.section++;
          this.valid = true;
        }
      },
      calculate: function() {
        const requestOptions = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ 
            cornBags: this.numberOfBags, 
            geese: this.numberOfGeese,
            ferrymansCharge: this.tripCurrency, 
            crocPrice: this.crocMeatPrice
          })
        };
        fetch("http://localhost:8080/api/v1/cornculate", requestOptions)
          .then(response => response.json())
          .then(data => (
            this.quote = data.ferrymansQuote, 
            this.meatCost = data.priceCrocMeat,
            this.directions = data.instructions));
      }
  },
  props: {
    msg: String
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.hello {
  padding: 1rem;
}
currency-input {
    display: block;
    width: 100%;
    height: calc(1.5em + 0.75rem + 2px);
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;  
}
.form-area {
  margin: 1rem auto;
  max-width: 24rem;
  min-height: 30rem;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.form-input {
    height: 50%;
}
.bags-input {
  margin-bottom: 1rem;
}
.bags-btns {
  margin-bottom: 1rem;
  display: flex;
  justify-content: space-evenly;
}
.bags-btn {
  width: 100%;
}
.bags-btn__increment {
  margin-right: 1rem;
}
.trip {
  margin-bottom: 1rem;
}
.ferry {
  margin-bottom: 1rem;
}
.trip-input {
    display: flex;
    align-items: baseline;
}
.trip-currency {
  margin-left: 0.5rem;
  display: block;
    width: 100%;
    height: calc(1.5em + 0.75rem + 2px);
    padding: 0.375rem 0.75rem;
    font-size: 1rem;
    font-weight: 400;
    line-height: 1.5;
    color: #495057;
    background-color: #fff;
    background-clip: padding-box;
    border: 1px solid #ced4da;
    border-radius: 0.25rem;
    transition: border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;  
}
.validation {
  height: 2rem;
  width: 100%;
}

.validation-message {
  color: red;
}

.validation-gif {
    top: 0;
    left: 0;
    position: absolute;
    width: 100%;
    display: flex;
    justify-content: center;
    height: 16rem;
}

#directions-list {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}
</style>
