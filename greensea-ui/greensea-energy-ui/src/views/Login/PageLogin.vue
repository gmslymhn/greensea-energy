<template>
  <div class="all">
<!--    登录表单-->
    <div class="LoginForm">
      <div class="fromTitle">
        <span>LOGIN</span>
      </div>
      <div class="FormSonContent">
      <div class="fromContent">
        <div class="userName">
          <el-input
              v-model="input4"
              size="large"
              style="width: 100%"
              placeholder="请输入您的用户名"
          >
            <template #prefix>
              <el-icon class="el-input__icon"><User /></el-icon>
            </template>
          </el-input>
        </div>
        <div class="Password">
          <el-input
              v-model="input"
              style="width: 100%"
              type="password"
              size="large"
              placeholder="请输入您的密码"
              show-password>

            <template #prefix>
              <el-icon class="el-input__icon"><Lock /></el-icon>
            </template>
            </el-input>
        </div>
        <div class="ForgetPassWord">
          <a href="#">忘记密码</a>
        </div>
        <div class="submitButton">
          <el-button color="#2e60bf" :dark="isDark" style="width: 100%">登&nbsp;&nbsp;&nbsp;录</el-button>
        </div>
        <div class="registerButton">
          <span>Dont have account?&nbsp;&nbsp;</span>
          <span><router-link to="/sign">Sign up</router-link></span>
        </div>
        <div class="dividingLine">
        </div>
        <div class="otherMethodCenter">
        <div class="otherMethod">
          <img src="../../assets/images/twitter.png">
          <img src="../../assets/images/google.png">
          <img src="../../assets/images/dribbble.png">
          <img src="../../assets/images/facebook.png">
        </div>
        </div>
      </div>
    </div>
    </div>
  </div>
</template>
<script setup>

</script>


<style scoped>
.all {
  width: 100%;
  height: 100vh; /* 确保 div 占满整个视窗高度 */
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url('../../assets/images/backGround.png');
  background-repeat: no-repeat;
  background-size: 100% 100%;
}

.LoginForm{
  width: 30%;
  height: 60%;
  background-color: rgba(255,255,255);
  border-radius: 20px;


}

.fromTitle{
  margin-top: 60px;
  margin-left: 40px;
  font-size: 30px;
  font-weight: bolder;
}
.FormSonContent{
  width: 100%;
  display: flex;
  justify-content: center;
}

.fromContent{
  width: 80%;
  margin-top: 40px;
}
.Password{
  margin-top: 20px;
}
.submitButton{
  margin-top: 20px;
}
.ForgetPassWord{
  font-size: 12px;
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}
.dividingLine{
  height: 1px;
  background: linear-gradient(to left, #ffffff 5%, #383838 50%,#ffffff 85%);
  margin-top: 20px;
}
.otherMethodCenter{
  margin-top: 20px;
  display: flex;
  justify-content: center;
}
.otherMethod{
  width: 50%;
  display: flex;
  justify-content: space-between;
}
.otherMethod img{
  width: 30px;
  height: 30px;
}

.registerButton{
  display: flex;
  justify-content: center;
  font-size: 12px;
  margin-top: 20px;
}

.el-button{
  height: 50px;
}

@media (max-width: 480px) {
  .LoginForm {
    margin-right: 10px;
    width: 90%;
    height: 80%;
  }

  .fromTitle {
    margin-top: 30px;
    margin-left: 10px;
    font-size: 20px;
  }

  .fromContent {
    width: 95%;
    margin-top: 10px;
  }

  .Password {
    margin-top: 5px;
  }

  .submitButton {
    margin-top: 10px;
  }

  .ForgetPassWord {
    font-size: 10px;
  }

  .registerButton {
    font-size: 10px;
  }

  .otherMethod img {
    width: 25px;
    height: 25px;
  }
}







</style>
