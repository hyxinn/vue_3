
<template>
  <div>
    <!-- header start-->
    <div style="height:60px;background-color: #5f96ed;display: flex;align-items: center">
      <div style="width:300px;display:flex;align-items: center;padding-left: 15px">
        <img style="width:40px" src="@/assets/icon_Rabbit.png" alt="">
        <span style="font-size: 22px;color:white;margin-left: 5px">Administration system</span>
      </div>
      <div style="flex:1"></div>
      <div style="width:fit-content;display:flex;align-items:center;padding-right:10px">
        <img src="@/assets/1.jpg" alt="" style="width:40px; height: 40px">
        <span style="color:white; margin-left: 5px">dantaxin</span>
      </div>
    </div>
    <!-- header finish-->
    <!-- body start-->
    <div style="display: flex">
      <div style="width:250px; border-right:1px solid #ddd; min-height: calc(100vh - 60px)">
        <!-- 左侧菜单栏开始-->
        <el-menu router :default-active="router.currentRoute.value.path" :default-openeds="[1]" style="border:0">
          <el-menu-item index="/manager/home">
            <el-icon><House/></el-icon>System Home Page
          </el-menu-item>
          <el-menu-item index="/manager/data">
            <el-icon><DataAnalysis/></el-icon>Data analysis
          </el-menu-item>
          <el-sub-menu index="1">
            <template #title>
              <el-icon><User/></el-icon>
              <span>User Management</span>
            </template>
            <el-menu-item  index="/manager/home">administrator informance</el-menu-item>
            <el-menu-item  index="/manager/home">regular user informance</el-menu-item>
          </el-sub-menu>
          <el-menu-item index="/manager/home">
            <el-icon><UserFilled/></el-icon>personal informance
          </el-menu-item>
          <el-menu-item index="/manager/home">
            <el-icon><SwitchButton/></el-icon>Log out
          </el-menu-item>
        </el-menu>
      </div>
    <!--左侧导航栏结束-->
    <!--body start-->
    <div style="flex:1; width:0; background-color:#b0d0f3; padding:10px ">
      <RouterView />
    </div>
    <!--body finish-->
  </div>

  </div>

</template>


<script setup>
import router from "@/router/index.js";
</script>

<style>
.el-menu.isactive{
  background-color: #5390ff !important;
}
</style>
