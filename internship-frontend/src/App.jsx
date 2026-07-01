import { BrowserRouter, Routes, Route } from "react-router-dom";

import Sidebar from "./components/Sidebar";
import Navbar from "./components/Navbar";

import Dashboard from "./pages/Dashboard";
import Interns from "./pages/Interns";
import Tasks from "./pages/Tasks";
import Attendance from "./pages/Attendance";
import Certificates from "./pages/Certificates";

import "./styles/dashboard.css";

function App() {
  return (
    <BrowserRouter>
      <div className="app-container">
        <Sidebar />

        <main className="main-content">
          <Navbar />

          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/interns" element={<Interns />} />
            <Route path="/tasks" element={<Tasks />} />
            <Route path="/attendance" element={<Attendance />} />
            <Route path="/certificates" element={<Certificates />} />
          </Routes>

        </main>
      </div>
    </BrowserRouter>
  );
}

export default App;