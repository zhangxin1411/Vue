<template>
  <div class="login_container">
    <div class="login_box">
       <div class="avatar_box">
         <img class="logo_img" src="../../assets/logo.png" alt="logo.png">
       </div>
       <div>
         <el-form ref="LoginFormRel" :model="LoginForm" :rules="loginFormRules" label-width="10px" style="margin-top: 90px;margin-right: 10px;">
          <!-- 用户名  -->
           <el-form-item prop="username">
              <el-input v-model="LoginForm.username"></el-input>
           </el-form-item>
           <!-- 密码  -->
           <el-form-item prop="password">
              <el-input  v-model="LoginForm.password"></el-input>
           </el-form-item>
         </el-form>
       </div>
       <div>
         <el-row style="margin-left: 240px">
           <el-button type="primary" @click="login">登录</el-button>
           <el-button type="info" @click="resetLoginForm">重置</el-button>
         </el-row>
       </div>
    </div>
  </div>

</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      // 登录表单数据对象
      LoginForm: {
        username: '',
        password: ''
      },
      loginFormRules: {
        username: [
          {required: true, message: '请输入登录名称', trigger: 'blur'},
          {min: 3, max: 10, message: '长度在3到5个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '请输入登录密码', trigger: 'blur'},
          {min: 6, max: 15, message: '长度在6到15个字符', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    // 重置表单
    resetLoginForm () {
      this.$refs.LoginFormRel.resetFields()
    },
    login () {
      // 表单验证
      this.$refs.LoginFormRel.validate(async isValid => {
        if (!isValid) { return }
        const {data: result} = await this.$http.post('login', this.LoginForm)
        if (result.success) {
          this.$message.success('登录成功！')
          this.$router.push('/home')
        } else {
          this.$message.error('用户名或密码错误！')
        }
      })
    }
  }
}
</script>

<style scoped>

.login_container{
  background-color: #2b4b6b;
  height: 100%;
  position: relative;
}
.login_box{
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  margin: auto;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
}
.avatar_box{
  height: 130px;
  width: 130px;
  border: 1px solid #eee;
  border-radius: 50%;
  padding: 10px;
  box-shadow:0 0 10px #ddd;
  position:absolute;
  left:50%;
  transform: translate(-50%,-50%);
  background-color: #fff;
}
.logo_img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background-color: #eee;
}
</style>
<!--
验证规则：1.在<el-form>中配置rules 2. <el-form-item> 配置规则名称 3.在<script>中编写规则
数据绑定：1.<el-form> 中：model 配置数据模型名称 2.<el-input> 标签中模型.属性 3. 在<script>编写属性
-->
