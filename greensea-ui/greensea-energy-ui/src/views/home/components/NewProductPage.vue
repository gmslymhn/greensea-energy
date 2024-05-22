<template>
  <div class="newProduct" :id="id">
    <div class="newProductLeft">
      <div class="productLeftContent">
        <div class="productLeftTitle">
          Latest Product
        </div>
        <div class="productContent">
          <span class="productIntroduction">Product Introduction</span>
          <div class="productText">
            <p>High Efficiency Solar Panels:
              The SolarMax Pro utilizes state-of-the-art photovoltaic technology, boasting an impressive efficiency rate of up to 22%. This means more energy captured from every ray of sunlight, providing maximum output even on cloudy days.</p>
          </div>

          <div class="moreProduct">
            <span><router-link to="">more product</router-link></span>
          </div>
        </div>
      </div>
    </div>
    <div class="newProductRight">
      <div class="productImgFirst">
        <img class="productImg" src="../../../assets/images/demo3.jpg">
      </div>
      <div class="productImgSecond">
        <img class="productImg" src="../../../assets/images/demo4.jpg">
      </div>
    </div>
  </div>
</template>

<script setup>
/* eslint-disable */
import { defineProps } from 'vue';
const props = defineProps({
  id: {
    type: String,
    default: ''
  }
})
</script>

<style scoped>
.newProduct {
  width: 100vw;
  height: 100vh;
  background: linear-gradient(#ffffff, #30394b);
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: row; /* Default to row layout */
}

.newProductLeft {
  width: 40%;
  height: 90%;
  display: flex;
  align-items: center;
}

.newProductRight {
  width: 40%;
  height: 90%;
  position: relative;
}

.productLeftTitle {
  color: #30394b;
  font-weight: bolder;
  font-size: 80px;
}

.productLeftContent {
  height: 80%;
  width: 100%;
}

.productIntroduction {
  font-size: 30px;
}

.productContent {
  margin-top: 10%;
}

.productText {
  width: 90%;
  margin-top: 5%;
  font-size: 18px;
}

.moreProduct {
  margin-top: 10%;
  width: 150px;
  height: 40px;
  border: 3px;
  display: flex;
  justify-content: center;
  align-items: center;
}

.moreProduct span a {
  font-size: 20px;
  color: #2e394b;
}

.moreProduct:hover {
  background-color: #30394b;
  color: white;
}

.moreProduct:hover span a {
  color: white;
}

.productImgFirst {
  position: absolute;
  top: 3%;
  left: 15%;
}

.productImgSecond {
  position: absolute;
  top: 40%;
}

@media (max-width: 768px) {
  .newProduct {

    flex-direction: column; /* Change layout to column for smaller screens */
    height: auto; /* Adjust height to fit content */
  }

  .newProductLeft,
  .newProductRight {
    width: 100%; /* Full width for each section */
    height: auto; /* Auto height to fit content */
    margin-left: 5%;
  }

  .productLeftTitle {
    font-size: 40px; /* Adjust font size for smaller screens */
  }

  .productIntroduction {
    font-size: 24px; /* Adjust font size for smaller screens */
  }

  .moreProduct span a {
    font-size: 16px; /* Adjust font size for smaller screens */
  }

  .newProductRight {
    display: flex; /* Flex layout for images */
    flex-direction: column; /* Column layout for images */
    align-items: center; /* Center align images horizontally */
    position: static; /* Remove absolute positioning */
    margin-top: 10px; /* Add top margin */
  }

  .productImgFirst,
  .productImgSecond {
    position: static; /* Remove absolute positioning */
    width: 90%; /* Adjust width to fit the screen */
    margin: 10px 0; /* Center align images with margin */
  }

  .productImg {
    width: 100%; /* Make both images the same width */
    height: auto; /* Maintain aspect ratio */
  }
}

@media (max-width: 480px) {
  .productLeftTitle {
    font-size: 32px; /* Further adjust font size for very small screens */
  }

  .productIntroduction {
    font-size: 20px; /* Further adjust font size for very small screens */
  }

  .moreProduct span a {
    font-size: 14px; /* Further adjust font size for very small screens */
  }

  .productImgFirst, .productImgSecond {
    width: 100%; /* Ensure full width for very small screens */
    margin: 10px 0; /* Maintain margin for spacing */
  }
}
</style>
