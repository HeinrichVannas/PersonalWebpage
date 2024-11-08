import React from 'react';
import ReactDom from 'react-dom/client';
import Router from './Route';

const root = ReactDom.createRoot(document.getElementById('root'));
root.render(
    <React.StrictMode>
        <Router />
    </React.StrictMode>
);