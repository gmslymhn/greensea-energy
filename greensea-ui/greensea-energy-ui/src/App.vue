<template>
  <!--路由的出口-->
  <HeaderPage v-show="$route.meta.header"></HeaderPage>
  <router-view></router-view>
</template>

<script>
import {defineComponent} from "vue";
import HeaderPage from "@/components/HeaderPage.vue";

export default defineComponent({
  components: {HeaderPage}
})
</script>

<style>
* {
  margin: 0;
  padding: 0;
  /* 內减模式 */
  box-sizing: border-box;
}

li {
  list-style: none;
}
a {
  text-decoration: none;
}

.clearfix:before,
.clearfix:after {
  content:"";
  display:table;
}
.clearfix:after {
  clear:both;
}

.wrapper {
  width: 1200px;
  margin: 0 auto;
}
</style>
