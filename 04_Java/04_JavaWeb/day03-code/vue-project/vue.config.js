const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  // 更改端口号
  devServer: {
    port: 7000
  }
})
