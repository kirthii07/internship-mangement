import { useEffect, useState } from "react";
import API from "../services/api";

function Tasks() {
  const [tasks, setTasks] = useState([]);

  const [formData, setFormData] = useState({
    internId: "",
    title: "",
    description: "",
    status: "",
  });

  useEffect(() => {
    fetchTasks();
  }, []);

  const fetchTasks = async () => {
    try {
      const response = await API.get("/tasks");
      setTasks(response.data);
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

  const addTask = async (e) => {
    e.preventDefault();

    try {
      await API.post("/tasks", formData);

      fetchTasks();

      setFormData({
        internId: "",
        title: "",
        description: "",
        status: "",
      });

    } catch (error) {
      console.log(error);
    }
  };

  return (
    <div>
      <h1>Task Management</h1>

      <form onSubmit={addTask} className="intern-form">

        <input
          type="number"
          name="internId"
          placeholder="Intern ID"
          value={formData.internId}
          onChange={handleChange}
        />

        <input
          type="text"
          name="title"
          placeholder="Task Title"
          value={formData.title}
          onChange={handleChange}
        />

        <input
          type="text"
          name="description"
          placeholder="Description"
          value={formData.description}
          onChange={handleChange}
        />

        <input
          type="text"
          name="status"
          placeholder="PENDING"
          value={formData.status}
          onChange={handleChange}
        />

        <button type="submit">
          Add Task
        </button>

      </form>

      <table className="intern-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Intern ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Status</th>
          </tr>
        </thead>

        <tbody>
          {tasks.map((task) => (
            <tr key={task.id}>
              <td>{task.id}</td>
              <td>{task.internId}</td>
              <td>{task.title}</td>
              <td>{task.description}</td>

              <td>
                <span
                  className={
                    task.status === "COMPLETED"
                      ? "status-completed"
                      : "status-pending"
                  }
                >
                  {task.status}
                </span>
              </td>

            </tr>
          ))}
        </tbody>

      </table>
    </div>
  );
}

export default Tasks;