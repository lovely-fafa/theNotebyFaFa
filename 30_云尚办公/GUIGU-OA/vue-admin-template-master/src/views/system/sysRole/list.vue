<template>
    <div class="app-container">

        <!--查询表单-->
        <div class="search-div">
            <el-form label-width="70px" size="small">
                <el-row>
                    <el-col :span="24">
                        <el-form-item label="角色名称">
                            <el-input style="width: 100%" v-model="searchObj.roleName"
                                      placeholder="角色名称"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row style="display:flex">
                    <el-button type="primary" icon="el-icon-search" size="mini" :loading="loading" @click="fetchData()">
                        搜索
                    </el-button>
                    <el-button icon="el-icon-refresh" size="mini" @click="resetData">重置</el-button>
                </el-row>
            </el-form>
        </div>

        <!-- 表格 -->
        <el-table
            v-loading="listLoading"
            :data="list"
            stripe
            border
            style="width: 100%;margin-top: 10px;"
            @selection-change="handleSelectionChange">

            <el-table-column type="selection"/>

            <el-table-column
                label="序号"
                width="70"
                align="center">
                <template slot-scope="scope">
                    {{ (page - 1) * limit + scope.$index + 1 }}
                </template>
            </el-table-column>

            <el-table-column prop="roleName" label="角色名称"/>
            <el-table-column prop="roleCode" label="角色编码"/>
            <el-table-column prop="createTime" label="创建时间" width="160"/>
            <el-table-column label="操作" width="200" align="center">
                <template slot-scope="scope">
                    <el-button type="primary" icon="el-icon-edit" size="mini" @click="edit(scope.row.id)" title="修改"/>
                    <el-button type="danger" icon="el-icon-delete" size="mini" @click="removeDataById(scope.row.id)"
                               title="删除"/>
                    <el-button type="warning" icon="el-icon-edit" size="mini" @click="showAssignAuth(scope.row)"
                               title="分配权限"/>
                </template>
            </el-table-column>
        </el-table>

        <br>
        <div class="tools-div">
            <el-button type="success" icon="el-icon-plus" size="mini" @click="add"
                       :disabled="$hasBP('btn.sysRole.add')  === false">添 加
            </el-button>
            <el-button class="btn-add" size="mini" @click="batchRemove()">批量删除</el-button>
        </div>

        <!-- 分页组件 -->
        <el-pagination
            :current-page="page"
            :total="total"
            :page-size="limit"
            style="padding: 30px 0; text-align: center;"
            layout="total, prev, pager, next, jumper"
            @current-change="fetchData"
        />

        <el-dialog title="添加/修改" :visible.sync="dialogVisible" width="40%">
            <el-form ref="dataForm" :model="sysRole" label-width="150px" size="small" style="padding-right: 40px;">
                <el-form-item label="角色名称">
                    <el-input v-model="sysRole.roleName"/>
                </el-form-item>
                <el-form-item label="角色编码">
                    <el-input v-model="sysRole.roleCode"/>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false" size="small" icon="el-icon-refresh-right">取 消</el-button>
                <el-button type="primary" icon="el-icon-check" @click="saveOrUpdate()" size="small">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>

import {getPageList, removeById, removeByIds, save, selectById, update} from '@/api/system/sysRole'

export default {
    data() {
        return {
            list: [],
            page: 1,
            limit: 5,
            total: 0,
            searchObj: {},
            dialogVisible: false,
            sysRole: {},
            selects: []
        }
    },
    created() {
        this.fetchData()
    },
    methods: {
        fetchData(current = 1) {
            this.page = current
            getPageList(this.page, this.limit, this.searchObj)
                .then(resp => {
                    this.list = resp.data.records
                    this.total = resp.data.total
                })
        },
        // 根据id删除数据
        removeDataById(id) {
            // debugger
            this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => { // promise
                // 点击确定，远程调用ajax
                return removeById(id)
            }).then((response) => {
                this.fetchData(this.page)
                this.$message.success(response.message || '删除成功')
            })
        },
        add() {
            this.dialogVisible = true
        },
        // 角色添加
        saveOrUpdate() {
            console.log(!this.sysRole.id)
            if (this.sysRole.id) {
                this.update()
            } else {
                this.save()
            }
        },
        save() {
            save(this.sysRole)
                .then(resp => {
                    // 提示信息
                    this.$message.success(resp.message || '删除成功')
                    // 关闭弹窗
                    this.dialogVisible = false
                    // 刷新页面
                    this.fetchData()
                    this.sysRole = {}
                })
        },
        update() {
            update(this.sysRole)
                .then(resp => {
                    // 提示信息
                    this.$message.success(resp.message || '更新成功')
                    // 关闭弹窗
                    this.dialogVisible = false
                    // 刷新页面
                    this.fetchData()
                    this.sysRole = {}
                })
        },
        edit(id) {
            console.log(this.sysRole.id)
            this.sysRole = {}
            this.dialogVisible = true
            selectById(id)
                .then(resp => {
                    this.sysRole = resp.data
                })
        },
        handleSelectionChange(selects) {
            this.selects = selects
            console.log(this.selects)
        },
        batchRemove() {
            if (this.selects.length === 0) {
                this.$message.warning('请选择后再进行批量删除')
                return
            }

            const ids = []
            this.selects.forEach((item) => {
                ids.push(item.id)
            })

            removeByIds(ids)
                .then((resp) => {
                    this.fetchData()
                })
        },
        showAssignAuth(row) {
            // 路由跳转
            this.$router.push('/system/assignAuth?id=' + row.id + '&roleName=' + row.roleName)
        }
    }
}
</script>
