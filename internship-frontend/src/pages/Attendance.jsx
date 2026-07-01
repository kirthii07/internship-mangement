import { useEffect, useState } from "react";
import API from "../services/api";

function Attendance() {

  const [attendance, setAttendance] = useState([]);

  const [formData, setFormData] = useState({
    internId: "",
    date: "",
    status: "",
  });

  useEffect(() => {
    fetchAttendance();
  }, []);

  const fetchAttendance = async () => {
    try {
      const response = await API.get("/attendance");
      setAttendance(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });
  };

  const addAttendance = async (e) => {
    e.preventDefault();

    try {
      await API.post("/attendance", formData);

      fetchAttendance();

      setFormData({
        internId: "",
        date: "",
        status: "",
      });

    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>

      <h1>Attendance Management</h1>

      <form onSubmit={addAttendance} className="intern-form">

        <input
          type="number"
          name="internId"
          placeholder="Intern ID"
          value={formData.internId}
          onChange={handleChange}
        />

        <input
          type="date"
          name="date"
          value={formData.date}
          onChange={handleChange}
        />

        <select
          name="status"
          value={formData.status}
          onChange={handleChange}
        >
          <option value="">Select Status</option>
          <option value="PRESENT">Present</option>
          <option value="ABSENT">Absent</option>
        </select>

        <button type="submit">
          Mark Attendance
        </button>

      </form>

      <table className="intern-table">

        <thead>
          <tr>
            <th>ID</th>
            <th>Intern ID</th>
            <th>Date</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>

          {attendance.map((item) => (
            <tr key={item.id}>
              <td>{item.id}</td>
              <td>{item.internId}</td>
              <td>{item.date}</td>

              <td>
                <span
                  className={
                    item.status === "PRESENT"
                      ? "status-completed"
                      : "status-pending"
                  }
                >
                  {item.status}
                </span>
              </td>

            </tr>
          ))}

        </tbody>

      </table>

    </div>
  );
}

export default Attendance;