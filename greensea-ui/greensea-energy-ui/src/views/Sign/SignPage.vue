<template>
  <div class="all">
    <!--    登录表单-->
    <div class="LoginForm">
      <div class="fromTitle">
        <span>SIGN</span>
      </div>
      <div class="FormSonContent">
        <div class="fromContent">
          <el-form
          :rules = "rules"
          :model="signForm"
          :label-position="'right'"
          label-width="auto"
          >
          <el-form-item
              class="UserNickName"
              label="用户名"
          >
            <el-input
                v-model="signForm.userName"
                size="large"
                placeholder="请输入您的用户昵称"
                style="width: 100%"
            >
              <template #prefix>
                <el-icon><House /></el-icon>
              </template>
            </el-input>
          </el-form-item>
            <el-form-item
                class="userName"
                label="账号"
            >
              <el-input
                  v-model="signForm.userAccount"
                  size="large"
                  placeholder="请输入您的用户账号"
                  style="width: 100%"

              >
                <template #prefix>
                  <el-icon class="el-input__icon"><User /></el-icon>
                </template>

              </el-input>
            </el-form-item>
          <el-form-item class="emailInput">
            <el-form-item
                label="Email"
                :rules="[
                  {
                    message: 'Please input email address',
                    trigger: 'blur',
                  },
                  {
                    type: 'email',
                    message: 'Please input correct email address',
                    trigger: ['blur', 'change'],
                  },
                ]"

            >
              <el-input
                  v-model="email"
                  placeholder="请输入您的邮箱"
                  size="large"
                  style="width: 100%"
              >
                <template #prefix>
                  <el-icon><Message /></el-icon>
                </template>
              </el-input>
            </el-form-item>
          </el-form-item>
          <el-form-item
              class="Password"
              label="密码">
            <el-input
                v-model="signForm.pass"
                style="width: 100%"
                type="password"
                size="large"
                placeholder="请输入您的密码"
                show-password>

              <template #prefix>
                <el-icon class="el-input__icon"><Lock /></el-icon>
              </template>
            </el-input>
          </el-form-item>
            <el-form-item label="确认密码" prop="checkPass" class="checkPassword">
              <el-input
                  v-model="signForm.checkPass"
                  type="password"
                  autocomplete="off"
                  placeholder="请再次输入您的密码"
                  size="large"
                  style="width: 100%"

              />
            </el-form-item>
            <el-form-item
              class="verificationCode"
              label="验证码"
            >
              <el-input
                  v-model="signForm.verificationCode"
                  style="width: 100px"
              >
              </el-input>
              <el-button class="CodeButton" :disabled="isDisabled" @click="startCountdown">{{buttonText}}</el-button>

            </el-form-item>

          <div class="submitButton">
            <el-button color="#2e60bf" :dark="isDark" style="width: 100%">注&nbsp;&nbsp;&nbsp;册</el-button>
          </div>
          </el-form>
        </div>

      </div>
    </div>
  </div>
</template>
<script setup>
import {ref , reactive} from "vue";
const email = ref('')
const ruleFormRef = ref()
const buttonText = ref('发送验证码')
const isDisabled = ref(false)
const countDown = ref(60)
const validatePass = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the password'))
  } else {
    if (signForm.checkPass !== '') {
      if (!signForm.value) return
      ruleFormRef.value.validateField('checkPass')
    }
    callback()
  }
}
const validatePass2 = (rule, value, callback) => {
  if (value === '') {
    callback(new Error('Please input the password again'))
  } else if (value !== signForm.pass) {
    console.log('value',value)
    console.log('signForm.pass',signForm.pass)
    callback(new Error("Two inputs don't match!"))
  } else {
    callback()
  }
}

const signForm = reactive({
  userAccount:'',
  userName:'',
  pass: '',
  checkPass: '',
  age: '',
  verificationCode:'',
})

const rules = reactive({
  pass: [{ validator: validatePass, trigger: 'blur' }],
  checkPass: [{ validator: validatePass2, trigger: 'blur' }]
})

//隔60s发送才能发送一次验证码,
const startCountdown = () =>{
  isDisabled.value = true;
  buttonText.value = `${countDown.value}`
  let timer = setInterval(()=>{
    countDown.value--;
    if(countDown.value > 0){
      buttonText.value = `${countDown.value}s`;
    }
    else {
      clearInterval(timer);
      buttonText.value = '发送验证码';
      isDisabled.value = false;
      countDown.value = 60;
    }
  },1000)

}

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
}
.Password{
  margin-top: 20px;
}
.submitButton{
  margin-top: 20px;
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

.UserNickName{
  margin-top: 20px;
}
.verificationCode{
  position: relative;
}

.CodeButton{
  position: absolute;
  left: 70%;

}


@media (max-width: 480px) {
  .LoginForm {
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


  .otherMethod img {
    width: 25px;
    height: 25px;
  }
  .verificationCode{
    position: relative;
  }

  .CodeButton{
    position: absolute;
    left: 60%;

  }
}







</style>
