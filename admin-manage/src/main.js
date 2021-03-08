// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI, {Message,Button,FormItem,Input,Form} from 'element-ui'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'
import './assets/css/global.css'

Vue.config.$message = Message
Vue.config.productionTip = false

Vue.use(ElementUI)

Vue.prototype.$http = axios
axios.defaults.baseURL = 'http://127.0.0.1:8888/api/v1/'
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
