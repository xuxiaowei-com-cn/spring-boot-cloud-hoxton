<template>
  <el-container class="login">
    <el-header class="login-header">
      <div class="header-context">
        <h2>Spring Cloud Admin</h2>
      </div>
    </el-header>
    <el-main class="login-main">
      <el-form ref="loginRef" id="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
        <el-form-item prop="username">
          <i class="el-icon-user input-icon"></i>
          <el-input type="text" v-model="loginForm.username" class="input-icon-left" placeholder="请输入用户名"
                    :autocomplete="loginFormAutocomplete.username"></el-input>
        </el-form-item>
        <el-form-item prop="password">
          <i class="el-icon-lock input-icon"></i>
          <el-input type="password" v-model="loginForm.password" class="input-icon-left" placeholder="请输入密码"
                    :autocomplete="loginFormAutocomplete.password"></el-input>
        </el-form-item>
        <el-form-item prop="patchca">
          <i class="el-icon-picture-outline input-icon"></i>
          <el-input type="text" v-model="loginForm.patchca" class="input-icon-left patchca" placeholder="请输入验证码"
                    :autocomplete="loginFormAutocomplete.patchca"></el-input>
          <div class="patchca-img" @click="patchcaClick()">
            <el-image :src="patchcaSrc" fit="fit" alt="全自动区分计算机和人类的图灵测试">
              <template #error>
                <div class="image-slot" style="color: #c2c2c2; text-align: center">
                  图片加载失败
                </div>
              </template>
            </el-image>
          </div>
        </el-form-item>
        <el-form-item>
          <el-checkbox v-model="loginForm.rememberMe">记住我</el-checkbox>
          <el-link type="primary" target="_blank" :underline="false" href="#forget" class="forget">忘记密码？</el-link>
        </el-form-item>
        <el-form-item>
          <el-button @click="loginButton()" class="login-button">登录</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<script setup>
import {getCurrentInstance, reactive, ref} from 'vue'
import {login} from '../../api/login'

// 获取当前示例
const {ctx} = getCurrentInstance()

const patchcaSrc = ref('http://localhost:10401/patchca')

// 登录参数
const loginForm = reactive({
  username: null,
  password: null,
  rememberMe: false,
  patchca: null,
})

// 是否自动填充
const loginFormAutocomplete = reactive({
  username: 'on',
  password: 'off',
  patchca: 'off',
})

// 验证
const loginRules = reactive({
  username: [
    {required: true, message: '请输入用户名', trigger: 'blur'},
  ],
  password: [
    {required: true, message: '请输入密码', trigger: 'blur'},
  ],
  patchca: [
    {required: true, message: '请输入验证码', trigger: 'blur'},
  ]
})

/**
 * 更换全自动区分计算机和人类的图灵测试
 */
function patchcaClick() {
  patchcaSrc.value = patchcaSrc.value.split('?')[0] + '?t=' + new Date().getTime()
}

/**
 * 登录按钮
 */
function loginButton() {
  ctx.$refs['loginRef'].validate((valid) => {
    if (valid) {
      login({
        'username': loginForm.username,
        'remember-me': loginForm.rememberMe,
        'password': loginForm.password
      }).then(response => {
        console.info(response)
      }).catch(response => {
        console.error(response)
      })
    } else {
      console.error('请填写账户信息！')
    }
  })
}

</script>

<style lang="scss">
.login {
  .login-header {
    .header-context {
      text-align: center;
    }
  }

  .login-main {

    .login-form {
      margin-left: auto;
      margin-right: auto;

      .el-form-item {
        .forget {
          float: right;
        }

        .login-button {
          width: 100%;
        }

        .el-form-item__content {
          margin-left: auto;
          margin-right: auto;
        }

        .patchca {
          width: calc(100% - 120px - 5px);
        }

        .patchca-img {
          float: right;
          height: 40px;

          .el-image {
            border: 1px solid #DCDFE6;
            width: 120px;
            height: calc(40px - 1px - 1px);
            border-radius: 4px;
          }
        }
      }
    }
  }

}

/* 超小屏幕(手机<768px) */
@media screen and (max-width: 768px) {
  .login {
    padding: 60px 0 110px 0;

    .login-main {
      .login-form {

        .el-form-item {
          .el-form-item__content {
            width: 270px;
          }
        }
      }
    }
  }
}

/* 小屏幕(平板≥768px)、中等屏幕(桌面≥992px)、大型屏幕(桌面≥1200px) */
@media screen and (min-width: 768px) {
  .login {
    padding: 110px 0;

    .login-main {
      .login-form {

        .el-form-item {
          .el-form-item__content {
            width: 315px;
          }
        }
      }
    }
  }
}
</style>
