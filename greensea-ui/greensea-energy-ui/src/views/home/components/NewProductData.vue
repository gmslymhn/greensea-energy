<template>
<div class="newProductData">
  <div class="newContent">
    <div class="quantityContent">
      <el-statistic
          :value="quantityText"
          value-style="color:white;font-size:60px;font-weight:bolder"
      />
      <div class="quantityTitle">
        <span>equipment quantity</span>
      </div>
    </div>
    <div>
      <el-statistic
      :value="generationText"
      value-style="color:white;font-size:60px;font-weight:bolder"
      />
      <div class="quantityTitle">
        <span>gross generation</span>
      </div>
    </div>
  </div>
</div>
</template>

<script setup>
//
import {ref} from "vue";
import {useTransition} from '@vueuse/core'
const source = ref(0)
const generationTextSource = ref(0)
const quantityText = useTransition(source,{
  // 这个是控制速度的
  duration:5000
})
source.value = 9999
generationTextSource.value = 93

const generationText = useTransition(generationTextSource,{
  duration:8000
})
</script>

<style scoped>
.newProductData{
  width: 100%;
  height: 200px;
  background-color: #30394b;
  display: flex;
  justify-content: center;
}
.newContent{
  width: 50%;
  display: flex;
  justify-content: space-between;
}
.newProductData{
  color: white;
}
.quantityContent{
}
.el-statistic__content{
  color: white;
}

.quantityTitle{
  font-size: 20px;

}

</style>