import express from "express";
import {
  getElektronik,
  getElektronikById,
  createElektronik,
  deleteElektronik,
} from "../controllers/Elektronik.js";
import { verifyUser, adminOnly } from "../middleware/AuthUser.js";
import { verifyWaste } from "../middleware/WasteVerify.js";

const router = express.Router();

router.get("/elektronik", verifyUser, getElektronik);
router.get("/elektronik/:id", verifyUser, getElektronikById);
router.post("/elektronik", adminOnly, verifyWaste, createElektronik);
router.delete("/elektronik/:id", verifyUser, adminOnly, deleteElektronik);

export default router;
