<template>
  <div>
    <div style="font-size: 20px;font-weight:bold;color:red;text-decoration:underline;font-style: italic">
      欢迎大家来到蛋挞欣的网页，这是我的第一站！
    </div>

    <div>
      {{a}}  {{b}}
    </div>

    <div style="font-style: italic;font-size: 55px;color:purple">
      {{data.a}} {{data.b}} {{data.c}} {{data.d}}
    </div>

    <div style="margin-bottom: 20px">
      <input v-model="data.name"/>
    </div>

    <div>
      <span style="color:red" v-if="data.name==='佩奇'">小猪佩奇</span>
      <span style="color:blue" v-if="data.name==='乔治'">小猪乔治</span>
      <span style="color:deeppink" v-else="data.name==='多多'">小多多</span>
    </div>

    <div style="display: flex; margin-bottom:20px">
      <div @click="show(item)" style="width:300px; height:300px;text-align: center; line-height:300px; font-size:30px; margin-right:10px; background-color: green" v-for="item in data.arr">
        {{item}}
      </div>
    </div>

    <div>
      <select style="width:200px">
        <option v-for="item in data.fruits">
          {{item}}
        </option>
      </select>
    </div>

    <div style="margin-bottom: 20px">
      <button @click="click">点我加好运</button>
    </div>

    <div>
      <div :style="data.box"></div>
      <div>
        <img :src="data.img" alt="">
      </div>
    </div>

    <div>
      <el-button>default</el-button>
      <el-button  @click="clickData" :style="{color:'red'}">美丽一天</el-button>
      <el-button type="success" plain>success</el-button>
      <el-button type="info" plain>Info</el-button>
      <el-button type="warning" size="large" loading>Warning</el-button>
      <el-button type="danger" color="pink" style="color:deeppink">Danger</el-button>
    </div>

    <div style="margin:30px">
      <el-icon :size="20">
        <Edit/>
      </el-icon>

      <span style="margin-left:30px;color:pink">
        <el-icon :size="20" color="#666" style="top:4px">
          <View />
        </el-icon>100
      </span>
      <el-button type="danger" :icon="Delete" circle />

      <el-input
          v-model="data.a"
          style="width:240px"
          placeholder="Type something"
          :prefix-icon="Search"
      />

    </div>

  </div>
</template>

<script setup>
import {ref,reactive,onMounted} from "vue";
import {Delete, Search} from "@element-plus/icons-vue";


const a = ref(1)
const b =ref("我能做到我想做到的一切事情")

const data = reactive({
  a: 123,
  b: "万事开头难，做起来后面就好了",
  c: 102368,
  d: "一倍速就好慢慢来",
  name: '朵朵',
  arr: [5, 6, 7],
  fruits: ['apple', 'banana', 'orange'],
  box:{
    width:'100px',
    height:'100px',
    backgroundColor:'pink'
  },
  img: 'https://www.runoob.com/wp-content/uploads/2017/01/vue.png'
})
const clickData=()=>{
  alert("taday is lucky day！")
}
onMounted(()=>{
  console.log('页面加载完成')
})
const show=(value)=>{
  alert(value)

}
const  click=()=>{
  alert("luck +1!")




}
</script>
