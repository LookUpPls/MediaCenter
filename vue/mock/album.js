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
    },
    {
        url: '/getdir',
        type: 'post',
        response: () => {
            return {
                code: 20000,
                data: {
                    folderData: [
                        {src: "img/1994_1.gif", name: "1994_1"},
                        {src: "img/1994_2.jpg", name: "1994_2"},
                        {src: "img/1994_all.jpg", name: "1994_all"},
                        {src: "img/1994_close.jpg", name: "1994_close"},
                        {src: "img/1994_love.jpg", name: "1994_love"},
                        {src: "img/blackBorder.jpg", name: "blackBorder"},
                        {src: "img/car.jpg", name: "car"},
                        {src: "img/carInMountain.jpg", name: "carInMountain"},
                        {src: "img/city.jpg", name: "city"},
                        {src: "img/city_close.jpg", name: "city_close"},
                        {src: "img/city_far.jpg", name: "city_far"},
                        {src: "img/city_in_air.jpg", name: "city_in_air"},
                        {src: "img/city_river.jpg", name: "city_river"},
                        {src: "img/folder.svg", name: "folder"},
                        {src: "img/game.jpg", name: "game"},
                        {src: "img/girl.jpeg", name: "girl"},
                        {src: "img/girlInBed.jpg", name: "girlInBed"},
                        {src: "img/girlLayOnGround.jpg", name: "girlLayOnGround"},
                        {src: "img/girl_small.jpg", name: "girl_small"},
                        {src: "img/grablage.svg", name: "grablage"},
                        {src: "img/jepan.jpg", name: "jepan"},
                        {src: "img/logo.png", name: "logo"},
                        {src: "img/road.jpg", name: "road"},
                        {src: "img/warm.jpg", name: "warm"},
                        {src: "img/镂空垃圾桶.svg", name: "镂空垃圾桶"},
                    ],
                    picData: [
                        {src: "img/1994_1.gif", name: "1994_1"},
                        {src: "img/1994_2.jpg", name: "1994_2"},
                        {src: "img/1994_all.jpg", name: "1994_all"},
                        {src: "img/1994_close.jpg", name: "1994_close"},
                        {src: "img/1994_love.jpg", name: "1994_love"},
                        {src: "img/blackBorder.jpg", name: "blackBorder"},
                        {src: "img/car.jpg", name: "car"},
                        {src: "img/carInMountain.jpg", name: "carInMountain"},
                        {src: "img/city.jpg", name: "city"},
                        {src: "img/city_close.jpg", name: "city_close"},
                        {src: "img/city_far.jpg", name: "city_far"},
                        {src: "img/city_in_air.jpg", name: "city_in_air"},
                        {src: "img/city_river.jpg", name: "city_river"},
                        {src: "img/folder.svg", name: "folder"},
                        {src: "img/game.jpg", name: "game"},
                        {src: "img/girl.jpeg", name: "girl"},
                        {src: "img/girlInBed.jpg", name: "girlInBed"},
                        {src: "img/girlLayOnGround.jpg", name: "girlLayOnGround"},
                        {src: "img/girl_small.jpg", name: "girl_small"},
                        {src: "img/grablage.svg", name: "grablage"},
                        {src: "img/jepan.jpg", name: "jepan"},
                        {src: "img/logo.png", name: "logo"},
                        {src: "img/road.jpg", name: "road"},
                        {src: "img/warm.jpg", name: "warm"},
                        {src: "img/镂空垃圾桶.svg", name: "镂空垃圾桶"},
                    ]
                }
            }
        }
    }
]

