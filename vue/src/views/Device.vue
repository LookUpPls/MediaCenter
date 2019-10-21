<template>
    <div class="device">
        <a-table :rowSelection="rowSelection" :columns="columns" :dataSource="data">

            <span slot="status" slot-scope="text"><a-badge :status=text :text="badgeMap[text]"/></span>

            <template slot="operation" slot-scope="text, record">
                <a href="javascript:;">全盘扫描</a>&nbsp;
                <a href="javascript:;">快速扫描</a>&nbsp;
                <a-popconfirm
                        title="确定要删除吗? 不会影响到现有内容"
                        @confirm="() => onDelete(record.key)"
                >
                    <a href="javascript:;">删除</a>
                </a-popconfirm>
            </template>

        </a-table>
    </div>
</template>

<script>
    const badgeMap = {
        success: '成功',
        error: '错误',
        default: '无动作',
        processing: '操作进行中',
        warning: '小错误',
    };
    const columns = [
        {
            title: '自定义名字',
            dataIndex: 'name',
        },
        {
            title: '名称',
            dataIndex: 'idea',
        },
        {
            title: '手机型号',
            dataIndex: 'type',
        }, {
            title: '状态',
            dataIndex: 'status',
            scopedSlots: {customRender: 'status'},
        }, {
            title: '上一次操作时间',
            dataIndex: 'time',
        }, {
            title: '操作',
            dataIndex: 'operation',
            scopedSlots: {customRender: 'operation'},
        },
    ];
    const data = [
        {
            key: '1',
            name: 'John Brown',
            idea: 3212351321231321,
            type: 'MI 8 SE',
            status: 'default',
            time: '2018-7-23',
            operation: 'dafdsa',
        },
        {
            key: '2',
            name: 'John Brown',
            idea: 3212351321231321,
            type: 'MI 8 SE',
            status: 'processing',
            time: '2018-7-23',
            operation: 'dafdsa',
        },
        {
            key: '3',
            name: 'John Brown',
            idea: 3212351321231321,
            type: 'MI 8 SE',
            status: 'success',
            time: '2018-7-23',
            operation: 'dafdsa',
        },
        {
            key: '4',
            name: 'John Brown',
            idea: 3212351321231321,
            type: 'MI 8 SE',
            status: 'processing',
            time: '2018-7-23',
            operation: 'dafdsa',
        },
    ];

    export default {
        data() {
            return {
                data,
                columns,
                badgeMap,
            };
        },
        computed: {
            rowSelection() {
                const {selectedRowKeys} = this;
                return {
                    onChange: (selectedRowKeys, selectedRows) => {
                        console.log(`selectedRowKeys: ${selectedRowKeys}`, 'selectedRows: ', selectedRows);
                    },
                    getCheckboxProps: record => ({
                        props: {
                            disabled: record.name === 'Disabled User', // Column configuration not to be checked
                            name: record.name,
                        },
                    }),
                };
            },
        },
    };
</script>
