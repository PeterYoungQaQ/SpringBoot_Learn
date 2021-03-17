<template>
  <div>
    <cube-tab-bar v-model="selectedLabel" show-slider>
      <cube-tab v-for="item in tabs" :label="item.label" :key="item.label">
      </cube-tab>
    </cube-tab-bar>
    
    <!--vue的过渡组件-->
    <transition
      :duration="{ enter: 100, leave: 100 }"
      mode="out-in"
    >
    <!--vue的动态组件-->
      <component
        :chapter_list="chapter_list"
        :is="selectedLabel==='简介'?'Summary':'Category'"
        :videoinfo="videoinfo"
      ></component>
    </transition>
  </div>
</template>

<script>
import Summary from './Summary'
import Category from './Catalog'
export default {
  components: {
    Summary,
    Category
  },
  props: {
    videoinfo: {
      type: Object,
      required: true,
    },
    chapter_list: {
      type: Array,
      required: true,
    },
  },
  data() {
    return {
      selectedLabel: '简介',
      tabs: [
        {
          label: '简介',
        },
        {
          label: '目录',
        },
      ],
    }
  },
}
</script>

<style lang="scss" scoped></style>
