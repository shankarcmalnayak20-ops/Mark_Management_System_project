package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.StudentMark;

public class MarkDAO {

    // =========================
    // ✅ INSERT
    // =========================
    public int add(StudentMark s) {

        int status = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO StudentMarks (StudentID, StudentName, Subject, Marks, ExamDate) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, s.getStudentID());
            ps.setString(2, s.getStudentName());
            ps.setString(3, s.getSubject());
            ps.setInt(4, s.getMarks());
            ps.setDate(5, s.getExamDate());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // =========================
    // ✅ UPDATE
    // =========================
    public int update(StudentMark s) {

        int status = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "UPDATE StudentMarks SET StudentName=?, Subject=?, Marks=?, ExamDate=? WHERE StudentID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, s.getStudentName());
            ps.setString(2, s.getSubject());
            ps.setInt(3, s.getMarks());
            ps.setDate(4, s.getExamDate());
            ps.setInt(5, s.getStudentID());

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // =========================
    // ✅ DELETE
    // =========================
    public int delete(int id) {

        int status = 0;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "DELETE FROM StudentMarks WHERE StudentID=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            status = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    // =========================
    // ✅ GET ALL (DISPLAY)
    // =========================
    public List<StudentMark> getAllMarks() {

        List<StudentMark> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM StudentMarks";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                StudentMark s = new StudentMark();

                s.setStudentID(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setSubject(rs.getString("Subject"));
                s.setMarks(rs.getInt("Marks"));
                s.setExamDate(rs.getDate("ExamDate"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // =========================
    // (OPTIONAL) GET BY ID
    // =========================
    public StudentMark getById(int id) {

        StudentMark s = null;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT * FROM StudentMarks WHERE StudentID=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                s = new StudentMark();

                s.setStudentID(rs.getInt("StudentID"));
                s.setStudentName(rs.getString("StudentName"));
                s.setSubject(rs.getString("Subject"));
                s.setMarks(rs.getInt("Marks"));
                s.setExamDate(rs.getDate("ExamDate"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}