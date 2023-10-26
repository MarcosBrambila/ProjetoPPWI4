import React from "react";
import { useState } from "react";
import Header from "../Header/Header";
import Sidebar from "../Sidebar/Sidebar";

const Layout = ({ children }) => {
    const [toggleSidebar, setToggleSidebar] = useState(true);

    const handleToggleSidebar = () => {
        console.log("Layout " + toggleSidebar)
        setToggleSidebar(!toggleSidebar);
    }

    return (
        <div>
            <Header isToggle={handleToggleSidebar}/>
            <Sidebar isToggle={toggleSidebar}/>
            <div className={toggleSidebar ? "app-content" : "app-content inactive"}>
                {children}
            </div>
        </div>
    )
}

export default Layout;