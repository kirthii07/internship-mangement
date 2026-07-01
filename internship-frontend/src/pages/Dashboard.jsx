import { useEffect, useState } from "react";
import API from "../services/api";
import StatCard from "../components/StatCard";

function Dashboard() {

  const [stats, setStats] = useState({
    interns: 0,
    tasks: 0,
    attendance: 0,
  });

  useEffect(() => {
    fetchStats();
  }, []);

  const fetchStats = async () => {
    const response = await API.get("/dashboard");
    setStats(response.data);
  };

  return (
    <div>

      <h1>Dashboard</h1>

      <div className="card-container">

        <StatCard
          title="Total Interns"
          value={stats.interns}
        />

        <StatCard
          title="Tasks"
          value={stats.tasks}
        />

        <StatCard
          title="Attendance"
          value={stats.attendance}
        />

      </div>

    </div>
  );
}

export default Dashboard;