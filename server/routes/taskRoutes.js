import express from "express"
import {
    createSubTask,
    createTask,
    dashboardStatistics,
    deleteRestoreTask,
    duplicateTask,
    getTask,
    getTasks,
    postTaskActivity,
    trashTask,
    updateTask,
} from "../controllers/taskController.js"
import { isAdminRoute, protectRoute } from "../middlewares/authMiddleware.js"

const router = express.Router()

// Create task (admin only)
router.post("/create", protectRoute, isAdminRoute, createTask)

// Duplicate task (admin only)
router.post("/duplicate/:id", protectRoute, isAdminRoute, duplicateTask)

// Post task activity (any authenticated user)
router.post("/activity/:id", protectRoute, postTaskActivity)

// Dashboard statistics (any authenticated user)
router.get("/dashboard", protectRoute, dashboardStatistics)

// Get all tasks (any authenticated user)
router.get("/", protectRoute, getTasks)

// Get a specific task (any authenticated user)
router.get("/:id", protectRoute, getTask)

// Create subtask (any authenticated user)
router.put("/create-subtask/:id", protectRoute, createSubTask)

// Update task (allow junior engineers to update tasks assigned to them, but admins can update any task)
router.put("/update/:id", protectRoute, updateTask)

// Trash task (admin only)
router.put("/:id", protectRoute, isAdminRoute, trashTask)

// Delete or restore task (admin only)
router.delete("/delete-restore/:id?", protectRoute, isAdminRoute, deleteRestoreTask)

export default router
