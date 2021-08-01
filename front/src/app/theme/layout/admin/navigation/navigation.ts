import {Injectable, OnInit} from '@angular/core';


export interface NavigationItem {
  id: string;
  title: string;
  type: 'item' | 'collapse' | 'group';
  translate?: string;
  icon?: string;
  hidden?: boolean;
  url?: string;
  classes?: string;
  exactMatch?: boolean;
  external?: boolean;
  target?: boolean;
  breadcrumbs?: boolean;
  function?: any;
  badge?: {
    title?: string;
    type?: string;
  };
  children?: Navigation[];
}

export interface Navigation extends NavigationItem {
  children?: NavigationItem[];
}

const NavigationItems   = [
 /* {
    id: 'navigation',
    title: 'Navigation',
    type: 'group',
    icon: 'icon-navigation',
    children: [
      {
        id: 'dashboard',
        title: 'Accueil',
        type: 'item',
        url: '/home',
        icon: 'feather icon-home',
        classes: 'nav-item',
      }
    ]
 }, */
 
  {
    id: 'forms',
    title: 'Evaluation',
    type: 'group',
    icon: 'icon-group',
    hidden : true,
    children: [
      {
        id: 'Auto Evaluation',
        title: 'Auto Evaluation',
        type: 'item',
        url: '/auto-evaluation',
        classes: 'nav-item',
        icon: 'feather icon-list'
      },
    ]
  },
  {
    id: 'Manager Evaluation',
    title: 'Manager Evaluation',
    type: 'group',
    icon: 'icon-group',
    hidden : true,
    children: [
      {
        id: 'Evaluation',
        title: 'Evaluation',
        type: 'item',
        url: '/evaluation',
        classes: 'nav-item',
        icon: 'feather icon-file'
      },
      {
        id: 'eips',
        title: 'Mon equipe EIPs',
        type: 'item',
        url: '/eips',
        classes: 'nav-item',
        icon: 'feather icon-grid',
      }
    ]
  },
];

@Injectable()
export class NavigationItem{
  get() {
    return NavigationItems;
  } 
}

/**{
    id: 'chart-maps',
    title: 'Chart & Maps',
    type: 'group',
    icon: 'icon-charts',
    children: [
      {
        id: 'charts',
        title: 'Charts',
        type: 'item',
        url: '/charts/morris',
        classes: 'nav-item',
        icon: 'feather icon-pie-chart'
      }
    ]
  },
  {
    id: 'pages',
    title: 'Pages',
    type: 'group',
    icon: 'icon-pages',
    children: [
      {
        id: 'auth',
        title: 'Authentication',
        type: 'collapse',
        icon: 'feather icon-lock',
        children: [
          {
            id: 'signup',
            title: 'Sign up',
            type: 'item',
            url: '/auth/signup',
            target: true,
            breadcrumbs: false
          },
          {
            id: 'signin',
            title: 'Sign in',
            type: 'item',
            url: '/auth/signin',
            target: true,
            breadcrumbs: false
          }
        ]
      },
      {
        id: 'sample-page',
        title: 'Sample Page',
        type: 'item',
        url: '/sample-page',
        classes: 'nav-item',
        icon: 'feather icon-sidebar'
      },
      {
        id: 'disabled-menu',
        title: 'Disabled Menu',
        type: 'item',
        url: 'javascript:',
        classes: 'nav-item disabled',
        icon: 'feather icon-power',
        external: true
      },
      {
        id: 'buy_now',
        title: 'Buy Now',
        type: 'item',
        icon: 'feather icon-book',
        classes: 'nav-item',
        url: 'https://codedthemes.com/item/datta-able-angular/',
        target: true,
        external: true
      }
    ]
  }
   /**{
    id: 'Evaluation',
    title: 'Evaluation',
    type: 'group',
    icon: 'icon-ui',
    children: [
      {
        id: 'basic',
        title: 'Component',
        type: 'collapse',
        icon: 'feather icon-box',
        children: [
          {
            id: 'button',
            title: 'Button',
            type: 'item',
            url: '/basic/button'
          },
          {
            id: 'badges',
            title: 'Badges',
            type: 'item',
            url: '/basic/badges'
          },
          {
            id: 'breadcrumb-pagination',
            title: 'Breadcrumb & Pagination',
            type: 'item',
            url: '/basic/breadcrumb-paging'
          },
          {
            id: 'collapse',
            title: 'Collapse',
            type: 'item',
            url: '/basic/collapse'
          },
          {
            id: 'tabs-pills',
            title: 'Tabs & Pills',
            type: 'item',
            url: '/basic/tabs-pills'
          },
          {
            id: 'typography',
            title: 'Typography',
            type: 'item',
            url: '/basic/typography'
          }
        ]
      }
    ]
  },  */
