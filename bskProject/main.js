import Vue from 'vue'
import App from './App'
import cakeCar from './common/cakeCar.js'
import httpUrl from './common/HttpUrl.js'
import User from './common/User.js'
import Order from './common/Order.js'

Vue.config.productionTip = false

Vue.prototype.$cakeCar = cakeCar;
Vue.prototype.$httpUrl = httpUrl;
Vue.prototype.$User = User;
Vue.prototype.$Order = Order;

App.mpType = 'app'

const app = new Vue({
	httpUrl,
	cakeCar,
	User,
	Order,
    ...App
})
app.$mount()
