package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class DriveFTC extends OpMode {

    DcMotor leftFront;
    @Override
    public void init() {
    leftFront=hardwareMap.dcMotor.get("leftFront");
    leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    @Override
    public void loop() {
    leftFront.setPower(-gamepad1.left_stick_y);
    }
}
