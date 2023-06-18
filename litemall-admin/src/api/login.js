import request from '@/utils/request'

export function register(username, password, avatarUrl) {
  const data = {
    username,
    password,
    avatarUrl
  }
  return request({
    url: '/auth/register',
    method: 'post',
    data
  })
}

export function loginByUsername(username, password) {
  const data = {
    username,
    password
  }
  return request({
    url: '/auth/login',
    method: 'post',
    data
  })
}

export function logout() {
  return request({
    url: '/auth/logout',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: '/auth/info',
    method: 'get',
    params: { token }
  })
}

