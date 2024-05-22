<template>
  <div class="CompanyProfile" :id="id">
    <div class="companyAll">
      <div class="CompanyLeft"></div>
      <div class="CompanyRight">
        <div class="CompanyRightText">
          <div class="companySubtitle">
            <span>About Company</span>
          </div>
          <div class="companyTitle">
            <div>We Are Solving All of Your</div>
            <div>Electric Problems</div>
          </div>
          <div class="companyContent">
            <p class="firstContent">Our industry's business policy encompasses the strategies, guidelines, and practices that technology companies use to achieve their goals and objectives. The policies may vary depending on the company's size, market position, and competitive landscape. Commodo erat amet vitae consectetur consectetur feugiat.</p>
            <p class="secondContent">Tellus viverra eu risus ut ipsum magna sed odio elit. Sed sem purus tincidunt condimentum amet condimentum massa. Nunc vel nascetur id cras.</p>
            <p class="thirdContent">Our industry's business policy encompasses the strategies, guidelines, and practices that technology companies use to achieve their goals and objectives. The policies may vary depending on the company's size, market position, and competitive landscape. Commodo erat amet vitae consectetur consectetur feugiat.</p>
          </div>
        </div>
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
});
</script>

<style scoped>
.CompanyProfile {
  width: 100vw;
  height: 100vh;
  background-color: white;
}

.companyAll {
  display: flex;
  height: 100vh;
  justify-content: center;
  align-items: center;
}

.CompanyLeft {
  width: 35%;
  height: 80vh;
  background-image: url('../../../assets/images/demo1.png');
  background-color: pink;
  background-size: cover;
  background-position: center;
}

.CompanyRight {
  width: 40%;
  height: 80vh;
}

.CompanyRightText {
  margin-top: 10%;
  margin-left: 10%;
  font-size: 20px;
}

.companySubtitle {
  color: #285e9b;
}

.companyTitle {
  margin-top: 5px;
  font-size: 45px;
}

.companyContent {
  margin-top: 5%;
  font-size: 17px;
}

.secondContent {
  margin-top: 30px;
}

.thirdContent {
  margin-top: 20px;
}

/* 移动端适配 */
@media (max-width: 768px) {
  .companyAll {
    flex-direction: column;
    height: auto;
    padding: 20px;
  }

  .CompanyLeft {
    width: 100%;
    height: 30vh;
  }

  .CompanyRight {
    width: 100%;
    height: auto;
  }

  .CompanyRightText {
    margin-top: 5%;
    margin-left: 0;
    padding: 0 10px;
    font-size: 16px;
  }

  .companyTitle {
    font-size: 30px;
  }

  .companyContent {
    font-size: 14px;
  }

  .secondContent {
    margin-top: 20px;
  }

  .thirdContent {
    margin-top: 15px;
  }
}

@media (max-width: 480px) {
  .CompanyRightText {
    margin-top: 5%;
    margin-left: 0;
    padding: 0 10px;
    font-size: 14px;
  }

  .companyTitle {
    font-size: 24px;
  }

  .companyContent {
    font-size: 12px;
  }

  .secondContent {
    margin-top: 15px;
  }

  .thirdContent {
    margin-top: 10px;
  }
}
</style>
