作者：缕缕阳光
链接：https://www.zhihu.com/question/50750032/answer/351312287
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

-- build                      # webpack配置目录
   |__ webpack.config.base.js # 基础配置
   |__ webpack.config.dev.js  # 开发环境配置 集成webpack-dev-server
   |__ webpack.config.pro.js  # 生产环境配置
   |__ webpack.config.mock.js # mock环境配置
-- mock                       # mock接口目录，mock按照模块划分
   |__ module1
       |__ index.js
   |__ module2
       |__ index.js
-- src                        # 源码目录
   |__ index.js               # 项目入口，注入store, 调用render方法
   |__ App
       |__ index.js           # 应用入口，页面整体布局，处理页面路由
       |__ index.less
   |__ Components
       |__ index.js           # 导出所有组件
       |__ components1        # [组件1]
           |__ index.js       # 组件实现源码文件
           |__ index.less
       |__ components2        # [组件2]
   |__ Pages                  
       |__ index.js           # 页面通过此文件统一导出（若需要code split，页在此文件完成）
       |__ page1              # [页面1]
           |__ index.js       # 页面具体业务代码
           |__ indes.less
       |__ page2              # [页面2]
   |__ Redux
       |__ index.js           # 导出封装后的所有store
       |__ reduxHelper.js     # redux帮助文件
       |__ request.js         # 封装Axois，比如所所有的方法进行拦截（inspector）
       |__ module1            # [模块1]store基于具体业务模块来编写，方便多页面调用
           |__ actionTypes.js 
           |__ actions.js     
           |__ reducers.js
           |__ services.js
       |__ module2            # [模块2]
-- package.json
-- .npmrc
-- .babelrc
-- .eslint
-- .gitignore
-- .editorconfig