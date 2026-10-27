# Write your MySQL query statement below
SELECT s.student_id, s.student_name, su.subject_name, 
(SELECT COUNT(*) FROM Examinations e 
WHERE s.student_id=e.student_id 
AND su.subject_name=e.subject_name 
) AS attended_exams
FROM Students s
CROSS JOIN Subjects su
ORDER BY s.student_id, su.subject_name;

