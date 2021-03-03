<template>
  <div class="hello">

    <transition name="fade" mode="out-in">
    <div class="form-area">
      <b-progress :value="section" :max="2" class="mb-3" variant="info"></b-progress>
      <div class="form-input bags" v-if="section==0">
        Number of bags:
        <b-form-input class="bags-input" v-model="numberOfBags" placeholder="How many bags"></b-form-input>
        <div class="bags-btns">
          <b-button class="bags-btn bags-btn__increment" variant="info" @click="incrementCounter">+</b-button>
          <b-button class="bags-btn" variant="info" @click="decrementCounter">-</b-button>
        </div>
      </div>

      <div class="form-input trip" v-if="section==1">
        How much is a single trip:
        <div class="trip-input">
          <currency-input 
            currency="GBP" 
            class="trip-currency" 
            v-model="tripCurrency" 
            placeholder="How much is a single trip?"/>
        </div>
      </div>

      <div class="form-input quote" v-if="section==2">
        Cost of ferry:
        <div class="trip-input">
          <currency-input 
            currency="GBP" 
            class="trip-currency" 
            v-model="quote"
            placeholder="Cost of ferry?"/>
        </div>
      </div>

      <b-button class="next-btn" variant="success" @click="changeSection" v-if="section<=1">Next</b-button>
      <b-button class="next-btn" variant="success" @click="changeSection" v-if="section>1">Calculate</b-button>
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
      tripCurrency: 0.0,
      quote: 0,
      priceOfTrip: 0,
    }
  },
  methods: {
      incrementCounter: function() {
          this.numberOfBags += 1;
      },
      decrementCounter: function() {
          if (this.numberOfBags >0) this.numberOfBags -= 1;
      },
      changeSection: function() {
        this.section++;
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
  margin: 3rem auto;
  max-width: 24rem;
  height: 24rem;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
.form-input {
    height: 100%;
    padding: 2rem 0;
}
.bags-input {
  margin-bottom: 1rem;
}
.bags-btns {
  display: flex;
  justify-content: space-evenly;
}
.bags-btn {
  width: 100%;
}
.bags-btn__increment {
  margin-right: 1rem;
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
</style>
