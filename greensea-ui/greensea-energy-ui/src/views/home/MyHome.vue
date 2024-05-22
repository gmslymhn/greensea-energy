<template>
  <HomePage :id="'homePage'"></HomePage>
  <CompanyProfile :id="'companyProfile'"></CompanyProfile>
  <NewProductPage :id="'newProduct'"></NewProductPage>
  <NewProductData></NewProductData>
<!--  <div id="test">这是一个测试</div>-->
</template>

<script setup>
import NewProductPage from "./components/NewProductPage.vue";
import HomePage from "@/views/home/components/HomePage.vue";
import CompanyProfile from "@/views/home/components/CompanyProfile.vue";
import NewProductData from "@/views/home/components/NewProductData.vue";
</script>

<style scoped>

</style>
