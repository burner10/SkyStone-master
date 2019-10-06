package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class DriveFTC extends OpMode {
    //boolean reverse=false;
    double speed=1;
    DcMotor leftFront, leftRear, rightFront, rightRear;
    int speedLeft=0;
    int speedRight=0;
    @Override
    public void init() {
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
        if (gamepad1.dpad_up) {
            speed = 1;
        }
        if (gamepad1.dpad_left || gamepad1.dpad_right) {
            speed = .5;
        }
        if (gamepad1.dpad_down) {
            speed = .2;
        }
        if (!gamepad1.left_bumper || !gamepad1.right_bumper) {
            double x = gamepad1.left_stick_x * speed; // * (reverse ? -1 : 1);
            double y = -gamepad1.left_stick_y * speed; // * (reverse ? -1 : 1);
            double turn =-1* gamepad1.right_stick_y * speed;
       /*double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y)    ;
        double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x) - Math.PI / 4;
        double rightX = gamepad1.right_stick_x;
        final double v1 = r * Math.cos(robotAngle) + rightX;
        final double v2 = r * Math.sin(robotAngle) - rightX;
        final double v3 = r * Math.sin(robotAngle) + rightX;
        final double v4 = r * Math.cos(robotAngle) - rightX;
        */
            leftFront.setPower(x + y + turn);
            rightFront.setPower(-x + y - turn);
            leftRear.setPower(-x + y + turn);
            rightRear.setPower(x + y - turn);
        }
        else
        {

            if (gamepad1.left_bumper)
            {
                speedLeft+=.1;
                speedRight-=.1;
                speedRight=speedRight%1;
                speedLeft=speedLeft%1;
            }
            else
            {
                speedLeft-=.1;
                speedRight+=.1;
                speedRight=speedRight%1;
                speedLeft=speedLeft%1;
            }
            leftFront.setPower(speedLeft*speed);
            leftRear.setPower(speedLeft*speed);
            rightFront.setPower(speedRight*speed);
            rightRear.setPower(speedRight*speed);
        }
    }
}
