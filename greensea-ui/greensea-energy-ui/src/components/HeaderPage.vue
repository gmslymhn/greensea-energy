<template>
  <div class="backDrop">
    <div class="topBackDrop">
      <div class="brand">
        <button class="menu-toggle" @click="toggleMenu">
          <span :class="{ 'open': isMenuOpen }"><img width="25px" src="../assets/images/unfold.png"></span>
        </button>
        <div class="brandSayOne">
          <img width="45px" height="45px" src="../assets/images/logo.png">
        </div>
        <div class="textLogo">
          <img width="200px" height="35px" src="../assets/images/textLogo.png">
        </div>
      </div>

      <div class="linkBackDrop" :class="{ 'open': isMenuOpen }">
        <ul>
          <li><router-link to="#homePage" class="home active">首页</router-link></li>
          <li><router-link to="#companyProfile" class="about">公司简介</router-link></li>
          <li class="dropDownBox">
            <el-dropdown @command = "handleCommand">
              <span class="el-dropdown-link">
                产品与方案
                <el-icon class="el-icon--right">
                  <arrow-down />
                </el-icon>
              </span>
              <template #dropdown>
                <el-dropdown-menu>
                  <el-dropdown-item command="newProduct">最新产品</el-dropdown-item>
                  <el-dropdown-item command="allProduct">全部产品</el-dropdown-item>
                  <el-dropdown-item command="schemePrediction">方案预测</el-dropdown-item>
                </el-dropdown-menu>
              </template>
            </el-dropdown>
          </li>
          <li><router-link to="#test">联系我们</router-link></li>
          <li class="verticalBar">|</li>
          <li><router-link to="/sign">注册</router-link></li>
          <li><router-link to="/login">登录</router-link></li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { ArrowDown } from "@element-plus/icons-vue";
import {useRouter} from "vue-router";

const isMenuOpen = ref(false);
const router = useRouter()
const toggleMenu = () => {
  isMenuOpen.value = !isMenuOpen.value;
};

// 下拉菜单的事件绑定，可以直接使用代码方式，就是不使用router-link,这里只能使用定时器了，感觉哪里奇奇怪怪的，下个礼拜

const handleCommand = (command) =>{
  console.log("发生了点击事件")
  console.log(`#${command}`)
  setTimeout(()=>{
    router.push({
      hash:`#${command}`
    })
  },100)


}
</script>

<style scoped>
/* 大背景 */
.backDrop {
  width: 100%;
  margin: 0 auto;
}

/* 顶部背景 */
.topBackDrop {
  width: 100%;
  height: 100px;
  background: #2e394b;
  z-index: 1;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 20px;
}

/* 标志背景 */
.brand {
  display: flex;
}

/* 标志字 */
.brandSayOne {
  margin-top: 7px;
  margin-left: 20px;
}

.textLogo {
  margin-top: 15px;
}

/* 菜单按钮 */
.menu-toggle {
  display: none;
  background: none;
  border: none;
  font-size: 30px;
  color: white;
  cursor: pointer;
}

.menu-toggle .open img{
  transform: rotate(90deg);
}

/* 联系我们背景 */
.telephoneBackDrop {
  position: relative;
  top: -100px;
  left: 270px;
  line-height: 100px;
}

/* 联系我们 */
.callUs {
  font-size: 12px;
  color: #ffffff;
}

.telephone {
  font-weight: 900;
}

/* 锚点 */
.linkBackDrop {
  display: flex;
  align-items: center;
}

.linkBackDrop ul {
  display: flex;
  padding: 0;
}

.linkBackDrop ul li {
  list-style: none;
  margin: 40px 20px;
  font-size: 14px;
  font-weight: 900;
}

.linkBackDrop ul li a {
  color: white;
}

.linkBackDrop ul li:last-child {
  color: gainsboro;
}

.active {
  color: #ffffff;
}

.linkBackDrop ul li a:hover {
  color: #ffffff;
}

.example-showcase .el-dropdown-link {
  cursor: pointer;
  color: #30394b;
  display: flex;
  align-items: center;
}

.el-dropdown {
  color: white;
}

/* 移动端适配 */
@media (max-width: 480px) {
  .topBackDrop {
    height: auto;
    flex-direction: column;
    align-items: flex-start;
    padding: 10px;
  }

  .brand {
    width: 100%;
  }

  .brandSayOne {
    margin-top: 10px;
    margin-left: 10px;
  }

  .textLogo {
    margin-top: 15px;
  }

  .menu-toggle {
    display: block;
  }

  .linkBackDrop {
    width: 100%;
    display: none;
    flex-direction: column;
    margin-top: 10px;
  }

  .linkBackDrop.open {
    display: flex;
  }

  .linkBackDrop ul {
    flex-direction: column;
    width: 100%;
  }

  .linkBackDrop ul li {
    margin: 10px 0;
  }

  .verticalBar{
    display: none;
  }
}
</style>
