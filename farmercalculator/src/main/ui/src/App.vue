<template>
  <div id="app">
    <Header/>
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <Footer />
  </div>
</template>

<script>
import Header from './components/Header.vue'
import HelloWorld from './components/HelloWorld.vue'
import Footer from './components/Footer.vue' 
export default {
  name: 'App',
  components: {
    HelloWorld,
    Header,
    Footer
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Akaya+Kanadaka&display=swap');

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
