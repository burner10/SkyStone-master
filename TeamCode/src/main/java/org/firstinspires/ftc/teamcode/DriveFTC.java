package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class DriveFTC extends OpMode {
    //boolean reverse=false;
    double speed=1;
    double w1=0;
    double w2=0;
    DcMotor leftFront, leftRear, rightFront, rightRear, linSlide1, linSlide2;
    Servo wrist1, wrist2;
    DcMotor leftFront, leftRear, rightFront, rightRear, forkOneRight, forkOneLeft, forkTwoLeft, forkTwoRight;
    double speedLeft=0;
    double speedRight=0;
    @Override
    public void init() {
        forkOneLeft=hardwareMap.dcMotor.get("fOL");
        forkOneRight=hardwareMap.dcMotor.get("fOR");
        forkTwoLeft=hardwareMap.dcMotor.get("fTL");
        forkTwoRight=hardwareMap.dcMotor.get("fTR");
        leftFront = hardwareMap.dcMotor.get("leftFront");
        leftRear = hardwareMap.dcMotor.get("leftRear");
        rightFront = hardwareMap.dcMotor.get("rightFront");
        rightRear = hardwareMap.dcMotor.get("rightRear");

        //leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        //rightRear.setDirection(DcMotorSimple.Direction.REVERSE);
        //rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        //leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    @Override
    public void loop() {

        //driving code start
        if (gamepad1.dpad_up) {
            speed = 1;
        }
        if (gamepad1.dpad_left || gamepad1.dpad_right) {
            speed = .5;
        }
        if (gamepad1.dpad_down) {
            speed = .2;
        }
            double x = gamepad1.left_stick_x * speed; // * (reverse ? -1 : 1);
            double y = -gamepad1.left_stick_y * speed; // * (reverse ? -1 : 1);
            double turn =-1* gamepad1.right_stick_y * speed;
            leftFront.setPower(x + y + turn);
            rightFront.setPower(-x + y - turn);
            leftRear.setPower(-x + y + turn);
            rightRear.setPower(x + y - turn);
        //driving code end

        //arm code start
        double armSpeed1=gamepad2.left_stick_y;
        double armSpeed2=gamepad2.right_stick_y;
        forkOneLeft.setPower(armSpeed1);
        forkOneRight.setPower(armSpeed1);
        forkTwoLeft.setPower(armSpeed2);
        forkTwoRight.setPower(armSpeed2);
        //arm code end
    }
}
