import { createRouter, createWebHashHistory } from "vue-router";
import AppView from "@/views/AppView.vue";
import StackView from "@/views/StackView.vue";
import PortfolioView from "@/views/PortfolioView.vue";
import ContactView from "@/views/ContactView.vue";
import HomeView from "@/views/HomeView.vue";

const routes = [
    {
        path: "/app",
        name: "app",
        component: AppView
    },
    {
        path: "/stack",
        name: "stack",
        component: StackView
    },
    {
        path: "/portfolio",
        name: "portfolio",
        component: PortfolioView
    },
    {
        path: "/contacts",
        name: "contacts",
        component: ContactView
    },
    {
        path: "/",
        name: "home",
        component: HomeView
    },
];

const router = createRouter({
    history: createWebHashHistory(),
    routes,
});

export default router;