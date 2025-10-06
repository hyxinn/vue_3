<template>
  <div>
    <div style="margin-bottom: 20px">
      <RouterLink to="/test">通过router跳转到test</RouterLink>
      <a href="/test">通过a标签跳转到test</a>
    </div>


    <div style="margin: 20px">
      <el-button type="primary" @click="router.push('/test')">push跳转到test</el-button>
      <el-button type="primary" @click="router.replace('/test')">replace跳转到test</el-button>
    </div>


    <div style="margin-bottom: 10px">
      <el-button type="primary" @click="router.push({path:'/test',query:{id:2,name:'dantaxin'}})">路由传参id=2&name=蛋挞欣</el-button>
    </div>
    <div>
      <el-input  clearable v-model="data.input" style="width:240px" placeholder="tpye something" :prefix-icon="Search"  />
      {{data.input}}
      <el-input style="width:200px" :suffix-icon="Calendar"></el-input>
      <el-input type="textarea" v-model="data.descr" style="width:300px" placeholder="please input some description"></el-input>
    </div>

    <div style="margin: 50px">
      <el-select
          v-model="data.value"
          placeholder="please choose fruits!"
          size="large"
          style="width: 240px">
        <el-option
            v-for="item in data.options"
            :key="item.id"
            :label="item.label"
            :value="item.value"
        />
      </el-select> {{data.value}}

    </div>
    <div style="margin: 50px 0">
        <el-radio-group v-model="data.figure">
          <el-radio value="high">high</el-radio>
          <el-radio value="low">low</el-radio>
          <el-radio value="media">media</el-radio>
        </el-radio-group><span style="margin: 50px">
      {{data.figure}}
    </span>
    </div>

    <div style="margin: 50px">
      <el-radio-group v-model="data.like">
        <el-radio value="100" size="large" label="1" border>1</el-radio>
        <el-radio value="50" size="large" label="2" border>2</el-radio>
      </el-radio-group>{{data.like}}
    </div>

    <div style="margin: 50px">
      <el-checkbox-group v-model="data.checklist">
        <el-checkbox v-for="item in data.options" :key="item.id" :value="item.value" :label="item.label"/>
      </el-checkbox-group>{{data.checklist}}
    </div>
    <div style="margin: 50px 0">
      <img src="@/assets/image3.png" alt="" style="width:500px">
      <el-image :src="img" style="width:50px;margin-left: 100px" :preview-src-list="[img,'https://fuss10.elemecdn.com/a/3f/3302e58f9a181d2509f3dc0fa68b0jpeg.jpeg','https://fuss10.elemecdn.com/1/34/19aa98b1fcb2781c4fba33d850549jpeg.jpeg','https://fuss10.elemecdn.com/0/6f/e35ff375812e6b0020b6b4e8f9583jpeg.jpeg']"/>
    </div>

    <div style="margin: 500px">
      <el-carousel height="500px" width="400px">
        <el-carousel-item v-for="item in data.photo" :key="item">
          <img style="width:500px" :src="item" alt="">
        </el-carousel-item>
      </el-carousel>
    </div>

    <div style="margin: 50px 0">
      <el-date-picker
          v-model="data.date"
          type="datetime"
          placeholder="Pick a Date"
          format="YYYY-MM-DD"
          value-format="YYYY-MM-DD"
      />{{data.date}}

      <el-date-picker
          style="margin: 20px"
          v-model="data.time"
          type="datetime"
          placeholder="Pick a time"
          format="HH:mm:ss"
          value-format="HH:mm:ss"
      />{{data.time}}

      <el-date-picker
          style="margin: 20px"
          v-model="data.daterange"
          type="datetimerange"
          range-separator="To"
          start-placeholder="Start date"
          end-placeholder="End date"
          format="YYYY-MM-DD"
          value-format="YYYY-MM-DD"
      />{{data.daterange}}
    </div>
    <div style="margin: 20px 0">
      <el-table :data="data.tableData" style="width: 100%" stripe>
        <el-table-column prop="id" label="编号" width="180" />
        <el-table-column prop="date" label="日期" width="180" />
        <el-table-column prop="name" label="名字" width="180" />
        <el-table-column prop="address" label='地址' />
        <el-table-column label="操作">
          <template #default="scope">
            <el-button type="danger" circle @click="del(scope.row.id)">
              <el-icon><Delete/></el-icon>
            </el-button>
            <el-button type="primary" circle @click="edit(scope.row)">
              <el-icon><Edit/></el-icon>
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      <div style="margin: 10px 0">
            <el-pagination
                v-model:current-page="data.currentPage"
                v-model:page-size="data.pageSize"
                :page-sizes="[5,10,15,20]"
                background
                layout="total, sizes, prev, pager, next, jumper"
                :total="data.tableData.length"
            />
    </div>
    </div>


        <el-dialog v-model="data.dialogVisible" title="Edit" width="500">
          <div style="padding:20px">
            <div style="margin-bottom: 10px">日期：{{data.row.date}}</div>
            <div style="margin-bottom: 10px">名称：{{data.row.name}}</div>
            <div>地址：{{data.row.address}}</div>
          </div>
        </el-dialog>

  </div>
</template>

<script setup>
import {computed, reactive} from "vue"
import {Search,Calendar,Delete} from "@element-plus/icons-vue"
import img from '@/assets/image3.png'
import img1 from '@/assets/1.jpg'
import img2 from '@/assets/2.jpg'
import img3 from '@/assets/3.jpg'
import router from '@/router/index.js'

const data=reactive({
  id:router.currentRoute.value.query.id,
  name:router.currentRoute.value.query.name,
  input:'fighting!',
  descr:'可清空内容的属性可清空内容的属性可清空内容属性可清空内容的属性可清空内容的属性可清空内容的属性可清空内容的属性可清空内容的属性',
  value:'',
  options:[{id:1,label:'apple',value:'apple1'},
            {id:2,label:'peach',value:'peach'},
            {id:3,label:'pear',value:'pear'},
            {id:4,label:'apple',value:'apple2'},],
  figure:'high',
  like:'100',
  checklist:[],
  photo:[img1,img2,img3],
  date:'',
  time:'',
  daterange:{},
  tableData:[
    {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
    {id:'2',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'3',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'2',date:'2025-10-01',name:'欣',address:'内蒙古呼市'},
    {id:'1',date:'2025-10-02',name:'夏利',address:'内蒙古呼和浩特'},
    {id:'3',date:'2025-10-03',name:'小李',address:'内蒙古呼和浩特'},
    {id:'1',date:'2025-10-03',name:'利群',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-03',name:'林间七',address:'辽宁抚顺'},
    {id:'5',date:'2025-10-03',name:'王越',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'4',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
    {id:'2',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'3',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'2',date:'2025-10-01',name:'欣',address:'内蒙古呼市'},
    {id:'1',date:'2025-10-02',name:'夏利',address:'内蒙古呼和浩特'},
    {id:'3',date:'2025-10-03',name:'小李',address:'内蒙古呼和浩特'},
    {id:'1',date:'2025-10-03',name:'利群',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-03',name:'林间七',address:'辽宁抚顺'},
    {id:'5',date:'2025-10-03',name:'王越',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'4',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
    {id:'2',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'3',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'2',date:'2025-10-01',name:'欣',address:'内蒙古呼市'},
    {id:'1',date:'2025-10-02',name:'夏利',address:'内蒙古呼和浩特'},
    {id:'3',date:'2025-10-03',name:'小李',address:'内蒙古呼和浩特'},
    {id:'1',date:'2025-10-03',name:'利群',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-03',name:'林间七',address:'辽宁抚顺'},
    {id:'5',date:'2025-10-03',name:'王越',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'4',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'1',date:'2025-10-03',name:'胡雅欣',address:'内蒙古呼和浩特'},
    {id:'2',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'3',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'2',date:'2025-10-01',name:'欣',address:'内蒙古呼市'},
    {id:'1',date:'2025-10-02',name:'夏利',address:'内蒙古呼和浩特'},
    {id:'3',date:'2025-10-03',name:'小李',address:'内蒙古呼和浩特'},
    {id:'1',date:'2025-10-03',name:'利群',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-03',name:'林间七',address:'辽宁抚顺'},
    {id:'5',date:'2025-10-03',name:'王越',address:'内蒙古呼和浩特'},
    {id:'5',date:'2025-10-25',name:'胡',address:'内蒙古'},
    {id:'4',date:'2025-10-20',name:'雅欣',address:'呼和浩特'},
    {id:'5',date:'2025-10-01',name:'欣',address:'内蒙古呼市'}
  ],
  currentPage:1,
  pageSize:5,
  dialogVisible:false,
  row:null

})
data.tableData = data.tableData.splice(0,5)


const del=(id)=>{
  alert('delect id=' + id + '！')
}
const edit=(row)=>{
  data.row = row
  data.dialogVisible = true
}

</script>
