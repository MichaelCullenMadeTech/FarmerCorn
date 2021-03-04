<template>
    <section class="header">
        <!-- <div class="header-text">CORN-CULATOR</div> -->
        <img class="header-img" alt="Vue logo" src="../assets/1.png">
    </section>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>
.header {
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: 'Akaya Kanadaka', cursive;
    /* padding: 1rem; */
    background-color: rgb(93 224 230);
}
.header-text {
    font-size: xx-large;
    font-weight: 900;
    margin-right: 2rem;
    color: rgb(50 112 8);
}
img {
    height: 16rem;
}
</style>