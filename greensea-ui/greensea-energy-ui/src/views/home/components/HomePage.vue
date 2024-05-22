<template>
<div class="homePage" :id="id">
</div>
</template>

<script setup>
/* eslint-disable */
import {defineProps} from 'vue';
const props = defineProps({
  id:{
    type:String,
    default:''
  }
})
</script>

<style scoped>
.homePage{
  width: 100vw;
  height: 100vh;
  background: pink;
}

</style>