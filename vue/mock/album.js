export default [
    // {
    //     url: '/article/list',
    //     type: 'get',
    //     response: config => {
    //         const { importance, type, title, page = 1, limit = 20, sort } = config.query
    //
    //         let mockList = List.filter(item => {
    //             if (importance && item.importance !== +importance) return false
    //             if (type && item.type !== type) return false
    //             if (title && item.title.indexOf(title) < 0) return false
    //             return true
    //         })
    //
    //         if (sort === '-id') {
    //             mockList = mockList.reverse()
    //         }
    //
    //         const pageList = mockList.filter((item, index) => index < limit * page && index >= limit * (page - 1))
    //
    //         return {
    //             code: 20000,
    //             data: {
    //                 total: mockList.length,
    //                 items: pageList
    //             }
    //         }
    //     }
    // },

    {
        url: '/testMock',
        type: 'post',
        response: () => {
            return {
                code: 20000,
                data: "fdsafdsaf"
            }
        }
    }
]

