<template>
  <div>
    <div class="card" style="margin-bottom: 5px">
      <el-input style="width:240px; margin-right: 10px " v-model="data.name" placeholder="please input name to search" prefix-icon="Search"></el-input>
      <el-button type="primary">search</el-button>
      <el-button type="warning">reset</el-button>
    </div>
    <div class="card" style="margin-bottom: 5px">
      <el-button type="primary">increase</el-button>
      <el-button type="warning">batch delete</el-button>
      <el-button type="info">import</el-button>
      <el-button type="success">export</el-button>
    </div>
    <div class="card" style="margin-bottom: 5px">
      <el-table :data="data.tableData" style="width: 100%" stripe>
        <el-table-column prop="date" label="日期" width="180" />
        <el-table-column prop="name" label="名字" width="180" />
        <el-table-column prop="address" label='地址' />
      </el-table>
      <div style="margin-top:15px">
        <el-pagination
            v-model:current-page="data.pageNum"
            v-model:page-size="data.pageSize"
            :page-sizes="[5,10,15,20]"
            background
            layout="total, sizes, prev, pager, next, jumper"
            :total="data.total"
        />
      </div>
    </div>

  </div>

</template>

<script setup>
import {Search} from "@element-plus/icons-vue"
import {reactive} from "vue"

const data = reactive({

      tableData:[
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
        {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'}

],
      name:null,
      pageNum:1,
      pageSize:10,
      total:47

})

</script>

<style scoped>

</style>
