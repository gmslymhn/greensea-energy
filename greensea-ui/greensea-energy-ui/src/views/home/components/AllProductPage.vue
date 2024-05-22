<template>
  <div class="ProductAll" :id="id">
    <div class="allProductContent">
      <div>
        <span class="allProductTitle">New Product</span>
      </div>
      <div class="allProduct">
        <div>
          <img src="../../../assets/images/companyIntroduce.jpg">
          <div>
            介绍文字
          </div>
        </div>
        <div>
          <img src="../../../assets/images/companyIntroduce.jpg">
          <div>
            介绍文字
          </div>
        </div>
        <div>
          <img src="../../../assets/images/companyIntroduce.jpg">
          <div>
            介绍文字
          </div>
        </div>
      </div>
    </div>
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
.ProductAll{
  width: 100vw;
  height: 100vh;
  background: linear-gradient(#ffffff,#30394b);
  display: flex;
  justify-content: center;
  align-items: center;
}
.allProductContent{
  width: 90vw;
  height: 80vh;
}

.allProductTitle{
  font-size: 30px;
  font-weight: 500;

}
.allProduct{
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}

.allProduct img{
  width: 450px;
  height: 300px;
}
</style>