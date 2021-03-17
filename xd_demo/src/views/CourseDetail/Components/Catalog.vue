<template>
  <div class="cate_box">
    <div class="category">
      <!-- 遍历目录章节 -->
      <ul :key="item.id" class="content" v-for="(item, ind) in chapter_list">
        <h1>第{{ ind + 1 }}章 &nbsp;{{ item.title }}</h1>
        <li
          :key="item.id"
          class="sub_cate"
          v-for="(item, subind) in chapter_list[ind].episode_list"
        >
          <span class="sub_title"
            >{{ ind + 1 }}-{{ subind + 1 }} &nbsp; {{ item.title }}</span
          >
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  // 从父组件获取章节数据
  props: {
    chapter_list: {
      type: Array,
      required: true,
    },
  },
}
</script>

<style lang="scss" scoped>
// 目录包裹层设置边距
.cate_box {
  padding: 0 15px 50px;
  background-color: #fff;
  margin: 15px 0;
}

//每一章包裹层
.content {
  padding: 10px;
  // 章标题
  & h1 {
    font-size: 16px;
    width: 100%;
    margin-bottom: 15px;
    font-weight: bolder;
    // 设置章标题过长,超过行宽度省略隐藏
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}

//集包裹层
.sub_cate {
  font-size: 12px;
  padding: 10px 0;
  //集标题
  .sub_title {
    // 设置集标题过长,超过行宽度省略隐藏
    display: block;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
  }
}
</style>
