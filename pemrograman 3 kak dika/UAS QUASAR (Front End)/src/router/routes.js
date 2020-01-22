const routes = [
  // {
  //   path: '/',
  //   component: () => import('layouts/MyLayout.vue'),
  //   children: [
  //     {
  //       path: '',
  //       component: () => import('pages/index.vue')
  //     }
  //   ]
  // },
  {
    path: '/inputdata',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/inputdata.vue')
    }]
  },
  {
    path: '/baju2',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju2.vue')
    }]
  },
  {
    path: '/keranjang',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/keranjang.vue')
    }]
  },
  {
    path: '/baju3',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju3.vue')
    }]
  },
  {
    path: '/baju4',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju4.vue')
    }]
  },
  {
    path: '/baju5',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju5.vue')
    }]
  },
  {
    path: '/baju6',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju6.vue')
    }]
  },
  {
    path: '/baju7',
    component: () => import('layouts/guest.vue'),
    children: [{
      path: '',
      component: () => import('pages/baju7.vue')
    }]
  },
  {
    path: '/register',
    component: () => import('layouts/guest.vue'),
    children: [
      { path: '', component: () => import('pages/register.vue') }
    ]
  },
  // {
  //   path: '/akunsaya',
  //   component: () => import('layouts/guest.vue'),
  //   children: [
  //     { path: '', component: () => import('pages/akunsaya.vue') }
  //   ]
  // },
  {
    path: '/login',
    component: () => import('layouts/guest.vue'),
    children: [
      { path: '', component: () => import('pages/login.vue') }
    ]
  }
]
// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue')
  })
}

export default routes
