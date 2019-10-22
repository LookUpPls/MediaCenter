import request from '@/utils/request'

export function testMock() {
  return request({
    url: '/testMock',
    method: 'post'
  })
}
