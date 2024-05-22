<template>
<div class="newProductData"
 >
  <span>{{outputValue}}</span>
</div>
</template>

<script setup>
import {ref} from "vue";
import {useTransition} from '@vueuse/core'
const source = ref(0)
const outputValue = useTransition(source,{
  duration:1500
})
source.value = 9999
</script>

<style scoped>
.newProductData{
  width: 100%;
  height: 200px;
  background-color: #30394b;
}
.newProductData{
  color: white;
}

</style>