<template>
  <div class="login-container">
    <el-form ref="registerForm" :model="registerForm" :rules="loginRules" class="register-form" auto-complete="on" label-position="left">
      <div class="title-container">
        <h3 class="title">管理员注册</h3>
      </div>
      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user" />
        </span>
        <el-input v-model="registerForm.username" name="username" type="text" tabindex="1" auto-complete="on" placeholder="管理员账户" />
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password" />
        </span>
        <el-input v-model="registerForm.password" :type="passwordType" name="password" auto-complete="on" tabindex="2" show-password placeholder="管理员密码" @keyup.enter.native="handleRegister" />
      </el-form-item>

      <el-form-item label="设置头像">
        <el-upload
          :headers="headers"
          :action="imgV2UploadPath"
          :show-file-list="false"
          :on-success="uploadPicUrl"
          class="avatar-uploader"
          accept=".jpg,.jpeg,.png,.gif"
        >
          <img v-if="registerForm.avatarUrl" :src="registerForm.avatarUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon" />
        </el-upload>
      </el-form-item>

      <div class="buttons">
        <span><el-button :loading="loading" type="primary" style="width:49.5%;margin-bottom:30px;" @click.native.prevent="handleRegister">注册</el-button></span>
        <span><el-button style="width:49.5%;margin-bottom:30px;"><a href="#/login">切换登陆</a></el-button></span>
      </div>

    </el-form>

    <div class="copyright">
      Copyright © 2020 xxx.com 版权所有 <a href="http://www.example.com/">沪ICP备xxx号</a>
    </div>
  </div>
</template>

<script>
import { imgV2UploadPath } from '@/api/storage'
// import { getToken } from '@/utils/auth'
export default {
  name: 'Register',
  data() {
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('管理员密码长度应大于6'))
      } else {
        callback()
      }
    }
    return {
      imgV2UploadPath,
      // avatarUrl: '',  // 第二题
      registerForm: {
        username: 'admin123',
        password: 'admin123',
        avatarUrl: ''
      },
      loginRules: {
        username: [{ required: true, message: '管理员账户不允许为空', trigger: 'blur' }],
        password: [
          { required: true, message: '管理员密码不允许为空', trigger: 'blur' },
          { validator: validatePassword, trigger: 'blur' }
        ],
        avatarUrl: [{ required: true, message: '管理员头像不允许为空', trigger: 'blur' }]
      },
      passwordType: 'password',
      loading: false
    }
  },
  computed: {
    headers() {
      return {
        // 'X-Litemall-Admin-Token': getToken()
      }
    }
  },
  watch: {
    $route: {
      handler: function(route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }

  },
  created() {
    // window.addEventListener('hashchange', this.afterQRScan)
  },
  destroyed() {
    // window.removeEventListener('hashchange', this.afterQRScan)
  },
  methods: {
    uploadPicUrl: function(response) {
      this.registerForm.avatarUrl = response.data.url
    },
    handleRegister() {
      this.$refs.registerForm.validate(valid => {
        if (valid && !this.loading) {
          this.loading = true
          this.$store.dispatch('RegisterV1', this.registerForm).then(() => {
            this.$router.push({ path: this.redirect || '/' })
          }).catch(response => {
            this.$notify.error({
              title: '失败',
              message: response.data.errmsg
            })
            this.loading = false
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

/* reset element-ui css */
.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;

.login-container {
  min-height: 100%;
  width: 100%;
  background-color: $bg;
  overflow: hidden;

  .register-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;
  }

  .tips {
    font-size: 14px;
    color: #fff;
    margin-bottom: 10px;

    span {
      &:first-of-type {
        margin-right: 16px;
      }
    }
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 26px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: bold;
    }
  }
  .copyright {
    font-size: 12px;
    color: #fff;
    position: absolute;
    bottom: 0;
    left: 50%;
    transform: translate(-50%, -50%);
    margin-bottom: 20px;
    letter-spacing: 0.6px;
    a {
      font-weight: bold;
      border-bottom: 1px solid #fff;
      font-family: "PingFangSC-Semibold", sans-serif;
    }
  }
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 120px;
  height: 120px;
  line-height: 120px;
  text-align: center;
}
.avatar {
  width: 145px;
  height: 145px;
  display: block;
}
</style>

