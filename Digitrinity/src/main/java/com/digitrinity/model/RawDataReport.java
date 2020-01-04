package com.digitrinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "V_RawData_Report")
public class RawDataReport {
	
	@Column(name = "Cluster")
	private String cluster;
	
	@Column(name = "Site_id")
	private String siteId;
		
	@Column(name = "Updateddatetime")
	private String updateDateTime;
	
	@Id
	@Column(name = "tran_time")
	private String tranTime;
	
	@Column(name = "Alarmstring")
	private String alarm;
	
	@Column(name = "StatusString")
	private String status; 
	
	@Column(name = "CommunicationString")
	private String communication;
	
	@Column(name = "SysOutputLoadStatusstring")
	private String sysOutputLoadStatus;
	
	@Column(name = "Powersource")
	private String powerSource;
	
	@Column(name = "Sitebattvolt")
	private Double siteBatteryVolt; 
	
	@Column(name = "Batt_SOC")
	private Integer batterySOC;
	
	@Column(name = "Opco_1_LoadCurrent")
	private Double opco1LoadCurrent;
	
	@Column(name = "Opco_2_LoadCurrent")
	private Double opco2LoadCurrent;
	
	@Column(name = "Opco_3_LoadCurrent")
	private Double opco3LoadCurrent;
	
	@Column(name = "Opco_4_LoadCurrent")
	private Double opco4LoadCurrent;
	
	@Column(name = "Opco_1_Energy")
	private Double opco1Energy;
	
	@Column(name = "Opco_2_Energy")
	private Double opco2Energy;
	
	@Column(name = "Opco_3_Energy")
	private Double opco3Energy;
	
	@Column(name = "Opco_4_Energy")
	private Double opco4Energy;
	
	@Column(name = "Batt_1_temp")
	private Double battery1Temp;
	
	@Column(name = "Batt_2_temp")
	private Double battery2Temp;
	
	@Column(name = "Batt_3_temp")
	private Double battery3Temp;
	
	@Column(name = "Batt_4_temp")
	private Double battery4Temp;
	
	@Column(name = "Fuellevel_Percentage")
	private Integer fuelLevel;
	
	@Column(name = "Fuellevel_Ltrs")
	private Integer fuelLevelLtrs;
	
	@Column(name = "MDG_R_Volt")
	private Integer mdgRVolt;
	
	@Column(name = "MDG_Y_Volt")
	private Integer mdgYVolt;
	
	@Column(name = "MDG_B_Volt")
	private Integer mdgBVolt;
	
	@Column(name = "MDG_R_Amp")
	private Double mdgRAmp;
	
	@Column(name = "MDG_Y_Amp")
	private Double mdgYAmp;
	
	@Column(name = "MDG_B_Amp")
	private Double mdgBAmp;
	
	@Column(name = "MDG_R_PowerFactor")
	private Double mdgRPowerFactor;
	
	@Column(name = "MDG_Y_PowerFactor")
	private Double mdgYPowerFactor;
	
	@Column(name = "MDG_B_PowerFactor")
	private Double mdgBPowerFactor;
	
	@Column(name = "MDG_R_Power")
	private Double mdgRPower;
	
	@Column(name = "MDG_Y_Power")
	private Double mdgYPower;
	
	@Column(name = "MDG_B_Power")
	private Double mdgBPower;
	
	@Column(name = "MDG_Frequency")
	private Double mdgFrequency;
	
	@Column(name = "DG_R_Volt")
	private Integer dgRVolt;
	
	@Column(name = "DG_Y_Volt")
	private Integer dgYVolt;
	
	@Column(name = "DG_B_Volt")
	private Integer dgBVolt;
	
	
	@Column(name = "DG_R_Amp")
	private Double dgRAmp;
	
	@Column(name = "DG_Y_Amp")
	private Double dgYAmp;
	
	@Column(name = "DG_B_Amp")
	private Double dgBAmp;
	
	@Column(name = "DG_R_PowerFactor")
	private Double dgRPowerFactor;
	
	@Column(name = "DG_Y_PowerFactor")
	private Double dgYPowerFactor;
	
	@Column(name = "DG_B_PowerFactor")
	private Double dgBPowerFactor;
	
	@Column(name = "DG_R_Power")
	private Double dgRPower;
	
	@Column(name = "DG_Y_Power")
	private Double dgYPower;
	
	@Column(name = "DG_B_Power")
	private Double dgBPower;
	
	@Column(name = "DG_Frequency")
	private Double dgFrequency;
	
	@Column(name = "DG_Bat_Volt")
	private Double dgBatteryVoltage;
	
	@Column(name = "DG_Tank_Capacity")
	private Integer dgTankCapacity;
	
	@Column(name = "Batt_Charging_Current")
	private Double batterChargingCurrent;
	
	@Column(name = "Batt_Discharging_Current")
	private Double batterDisChargingCurrent;
	
	@Column(name = "Batt_Cycle_Count")
	private Integer batteryCycleCount;
	
	@Column(name = "Batt_Capacity_AH")
	private Integer batteryCapacityAH;
	
	@Column(name = "Batt_NextFullChargeTime")
	private Double batterNextFullChargeTime;
	
	@Column(name = "No_of_Batt_Strings")
	private Integer numberOfBatteries;
	
	@Column(name = "MDG_RunHrs")
	private Double mdgRunHours;
	
	@Column(name = "DG_RunHrs")
	private Double dgRunHours;
	
	@Column(name = "Batt_RunHrs")
	private Double batteryRunHours;
	
	@Column(name = "MDG_Energy")
	private Double mdgEnergy;
	
	@Column(name = "DG_Energy")
	private Double dgEnergy;
	
	@Column(name = "Batt_DisEnergy")
	private Double batteryDisEnergy;
	
	@Column(name = "Batt_ChargingEnergy")
	private Double batteryChargingEnergy;
	
	@Column(name = "Rect_Input_R_Voltage")
	private Integer rectInputRVoltage;
	
	@Column(name = "Rect_Input_Y_Voltage")
	private Integer rectInputYVoltage;
	
	@Column(name = "Rect_Input_B_Voltage")
	private Integer rectInputBVoltage;
	
	@Column(name = "Rect_Input_R_Current")
	private Double rectInputRCurrent;
	
	@Column(name = "Rect_Input_Y_Current")
	private Double rectInputYCurrent;
	
	@Column(name = "Rect_Input_B_Current")
	private Double rectInputBCurrent;
	
	@Column(name = "Rect_Output_Voltage")
	private Double rectOutputVoltage;
	
	@Column(name = "No_of_Rectfrs")
	private Integer numberOfRectfrs;
	
	@Column(name = "Total_Rect_Output_Current")
	private Double totalRectOutputCurrent;
	
	@Column(name = "Total_DCLoad_Current")
	private Double totalDCLoadCurrent;
	
	@Column(name = "Total_DCLoad_Energy")
	private Double totalDCLoadEnergy;
	
	@Column(name = "InputVoltage_SlrModule1")
	private Double inputVoltageSolarModule1;
	
	@Column(name = "InputCurrent_SlrModule1")
	private Double inputCurrentSolarModule1;
	
	@Column(name = "InputPower_SlrModule1")
	private Double inputPowerSolarModule1;
	
	@Column(name = "OutputVoltage_SlrModule1")
	private Double outputVoltageSolarModule1;
	
	@Column(name = "OutputCurrent_SlrModule1")
	private Double outputCurrentSolarModule1;
	
	@Column(name = "OutputPower_SlrModule1")
	private Double outputPowerSolarModule1;
	
	@Column(name = "SolarModule1Status")
	private String solarModule1Status;
	
	
	
	
	@Column(name = "InputVoltage_SlrModule2")
	private Double inputVoltageSolarModule2;
	
	@Column(name = "InputCurrent_SlrModule2")
	private Double inputCurrentSolarModule2;
	
	@Column(name = "InputPower_SlrModule2")
	private Double inputPowerSolarModule2;
	
	@Column(name = "OutputVoltage_SlrModule2")
	private Double outputVoltageSolarModule2;
	
	@Column(name = "OutputCurrent_SlrModule2")
	private Double outputCurrentSolarModule2;
	
	@Column(name = "OutputPower_SlrModule2")
	private Double outputPowerSolarModule2;
	
	@Column(name = "SolarModule2Status")
	private String solarModule2Status;
	
	
	@Column(name = "InputVoltage_SlrModule3")
	private Double inputVoltageSolarModule3;
	
	@Column(name = "InputCurrent_SlrModule3")
	private Double inputCurrentSolarModule3;
	
	@Column(name = "InputPower_SlrModule3")
	private Double inputPowerSolarModule3;
	
	@Column(name = "OutputVoltage_SlrModule3")
	private Double outputVoltageSolarModule3;
	
	@Column(name = "OutputCurrent_SlrModule3")
	private Double outputCurrentSolarModule3;
	
	@Column(name = "OutputPower_SlrModule3")
	private Double outputPowerSolarModule3;
	
	@Column(name = "SolarModule3Status")
	private String solarModule3Status;
	
	
	@Column(name = "InputVoltage_SlrModule4")
	private Double inputVoltageSolarModule4;
	
	@Column(name = "InputCurrent_SlrModule4")
	private Double inputCurrentSolarModule4;
	
	@Column(name = "InputPower_SlrModule4")
	private Double inputPowerSolarModule4;
	
	@Column(name = "OutputVoltage_SlrModule4")
	private Double outputVoltageSolarModule4;
	
	@Column(name = "OutputCurrent_SlrModule4")
	private Double outputCurrentSolarModule4;
	
	@Column(name = "OutputPower_SlrModule4")
	private Double outputPowerSolarModule4;
	
	@Column(name = "SolarModule4Status")
	private String solarModule4Status;
	
	
	
	@Column(name = "InputVoltage_SlrModule5")
	private Double inputVoltageSolarModule5;
	
	@Column(name = "InputCurrent_SlrModule5")
	private Double inputCurrentSolarModule5;
	
	@Column(name = "InputPower_SlrModule5")
	private Double inputPowerSolarModule5;
	
	@Column(name = "OutputVoltage_SlrModule5")
	private Double outputVoltageSolarModule5;
	
	@Column(name = "OutputCurrent_SlrModule5")
	private Double outputCurrentSolarModule5;
	
	@Column(name = "OutputPower_SlrModule5")
	private Double outputPowerSolarModule5;
	
	@Column(name = "SolarModule5Status")
	private String solarModule5Status;
	

	@Column(name = "InputVoltage_SlrModule6")
	private Double inputVoltageSolarModule6;
	
	@Column(name = "InputCurrent_SlrModule6")
	private Double inputCurrentSolarModule6;
	
	@Column(name = "InputPower_SlrModule6")
	private Double inputPowerSolarModule6;
	
	@Column(name = "OutputVoltage_SlrModule6")
	private Double outputVoltageSolarModule6;
	
	@Column(name = "OutputCurrent_SlrModule6")
	private Double outputCurrentSolarModule6;
	
	@Column(name = "OutputPower_SlrModule6")
	private Double outputPowerSolarModule6;
	
	@Column(name = "SolarModule6Status")
	private String solarModule6Status;
	
	
	@Column(name = "InputVoltage_SlrModule7")
	private Double inputVoltageSolarModule7;
	
	@Column(name = "InputCurrent_SlrModule7")
	private Double inputCurrentSolarModule7;
	
	@Column(name = "InputPower_SlrModule7")
	private Double inputPowerSolarModule7;
	
	@Column(name = "OutputVoltage_SlrModule7")
	private Double outputVoltageSolarModule7;
	
	@Column(name = "OutputCurrent_SlrModule7")
	private Double outputCurrentSolarModule7;
	
	@Column(name = "OutputPower_SlrModule7")
	private Double outputPowerSolarModule7;
	
	@Column(name = "SolarModule7Status")
	private String solarModule7Status;
	
	
	@Column(name = "InputVoltage_SlrModule8")
	private Double inputVoltageSolarModule8;
	
	@Column(name = "InputCurrent_SlrModule8")
	private Double inputCurrentSolarModule8;
	
	@Column(name = "InputPower_SlrModule8")
	private Double inputPowerSolarModule8;
	
	@Column(name = "OutputVoltage_SlrModule8")
	private Double outputVoltageSolarModule8;
	
	@Column(name = "OutputCurrent_SlrModule8")
	private Double outputCurrentSolarModule8;
	
	@Column(name = "OutputPower_SlrModule8")
	private Double outputPowerSolarModule8;
	
	@Column(name = "SolarModule8Status")
	private String solarModule8Status;
	
	
	@Column(name = "InputVoltage_SlrModule9")
	private Double inputVoltageSolarModule9;
	
	@Column(name = "InputCurrent_SlrModule9")
	private Double inputCurrentSolarModule9;
	
	@Column(name = "InputPower_SlrModule9")
	private Double inputPowerSolarModule9;
	
	@Column(name = "OutputVoltage_SlrModule9")
	private Double outputVoltageSolarModule9;
	
	@Column(name = "OutputCurrent_SlrModule9")
	private Double outputCurrentSolarModule9;
	
	@Column(name = "OutputPower_SlrModule9")
	private Double outputPowerSolarModule9;
	
	@Column(name = "SolarModule9Status")
	private String solarModule9Status;
	
	
	@Column(name = "InputVoltage_SlrModule10")
	private Double inputVoltageSolarModule10;
	
	@Column(name = "InputCurrent_SlrModule10")
	private Double inputCurrentSolarModule10;
	
	@Column(name = "InputPower_SlrModule10")
	private Double inputPowerSolarModule10;
	
	@Column(name = "OutputVoltage_SlrModule10")
	private Double outputVoltageSolarModule10;
	
	@Column(name = "OutputCurrent_SlrModule10")
	private Double outputCurrentSolarModule10;
	
	@Column(name = "OutputPower_SlrModule10")
	private Double outputPowerSolarModule10;
	
	@Column(name = "SolarModule10Status")
	private String solarModule10Status;
	
	@Column(name = "InputVoltage_SlrModule11")
	private Double inputVoltageSolarModule11;
	
	@Column(name = "InputCurrent_SlrModule11")
	private Double inputCurrentSolarModule11;
	
	@Column(name = "InputPower_SlrModule11")
	private Double inputPowerSolarModule11;
	
	@Column(name = "OutputVoltage_SlrModule11")
	private Double outputVoltageSolarModule11;
	
	@Column(name = "OutputCurrent_SlrModule11")
	private Double outputCurrentSolarModule11;
	
	@Column(name = "OutputPower_SlrModule11")
	private Double outputPowerSolarModule11;
	
	@Column(name = "SolarModule11Status")
	private String solarModule11Status;
	
	@Column(name = "InputVoltage_SlrModule12")
	private Double inputVoltageSolarModule12;
	
	@Column(name = "InputCurrent_SlrModule12")
	private Double inputCurrentSolarModule12;
	
	@Column(name = "InputPower_SlrModule12")
	private Double inputPowerSolarModule12;
	
	@Column(name = "OutputVoltage_SlrModule12")
	private Double outputVoltageSolarModule12;
	
	@Column(name = "OutputCurrent_SlrModule12")
	private Double outputCurrentSolarModule12;
	
	@Column(name = "OutputPower_SlrModule12")
	private Double outputPowerSolarModule12;
	
	@Column(name = "SolarModule12Status")
	private String solarModule12Status;
	
	
	@Column(name = "InputVoltage_SlrModule13")
	private Double inputVoltageSolarModule13;
	
	@Column(name = "InputCurrent_SlrModule13")
	private Double inputCurrentSolarModule13;
	
	@Column(name = "OutputVoltage_SlrModule13")
	private Double outputVoltageSolarModule13;
	
	@Column(name = "OutputCurrent_SlrModule13")
	private Double outputCurrentSolarModule13;
	
	@Column(name = "SolarModule13Status")
	private String solarModule13Status;
	
	
	@Column(name = "InputVoltage_SlrModule14")
	private Double inputVoltageSolarModule14;
	
	@Column(name = "InputCurrent_SlrModule14")
	private Double inputCurrentSolarModule14;
	
	@Column(name = "OutputVoltage_SlrModule14")
	private Double outputVoltageSolarModule14;
	
	@Column(name = "OutputCurrent_SlrModule14")
	private Double outputCurrentSolarModule14;
	
	@Column(name = "SolarModule14Status")
	private String solarModule14Status;
	
	@Column(name = "InputVoltage_SlrModule15")
	private Double inputVoltageSolarModule15;
	
	@Column(name = "InputCurrent_SlrModule15")
	private Double inputCurrentSolarModule15;
	
	@Column(name = "OutputVoltage_SlrModule15")
	private Double outputVoltageSolarModule15;
	
	@Column(name = "OutputCurrent_SlrModule15")
	private Double outputCurrentSolarModule15;
	
	@Column(name = "SolarModule15Status")
	private String solarModule15Status;
	
	@Column(name = "InputVoltage_SlrModule16")
	private Double inputVoltageSolarModule16;
	
	@Column(name = "InputCurrent_SlrModule16")
	private Double inputCurrentSolarModule16;
	
	@Column(name = "OutputVoltage_SlrModule16")
	private Double outputVoltageSolarModule16;
	
	@Column(name = "OutputCurrent_SlrModule16")
	private Double outputCurrentSolarModule16;
	
	@Column(name = "SolarModule16Status")
	private String solarModule16Status;
	
	
	@Column(name = "InputVoltage_SlrModule17")
	private Double inputVoltageSolarModule17;
	
	@Column(name = "InputCurrent_SlrModule17")
	private Double inputCurrentSolarModule17;
	
	@Column(name = "OutputVoltage_SlrModule17")
	private Double outputVoltageSolarModule17;
	
	@Column(name = "OutputCurrent_SlrModule17")
	private Double outputCurrentSolarModule17;
	
	@Column(name = "SolarModule17Status")
	private String solarModule17Status;
	
	
	@Column(name = "InputVoltage_SlrModule18")
	private Double inputVoltageSolarModule18;
	
	@Column(name = "InputCurrent_SlrModule18")
	private Double inputCurrentSolarModule18;
	
	@Column(name = "OutputVoltage_SlrModule18")
	private Double outputVoltageSolarModule18;
	
	@Column(name = "OutputCurrent_SlrModule18")
	private Double outputCurrentSolarModule18;
	
	@Column(name = "SolarModule18Status")
	private String solarModule18Status;
	
	@Column(name = "InputVoltage_SlrModule19")
	private Double inputVoltageSolarModule19;
	
	@Column(name = "InputCurrent_SlrModule19")
	private Double inputCurrentSolarModule19;
	
	@Column(name = "OutputVoltage_SlrModule19")
	private Double outputVoltageSolarModule19;
	
	@Column(name = "OutputCurrent_SlrModule19")
	private Double outputCurrentSolarModule19;
	
	@Column(name = "SolarModule19Status")
	private String solarModule19Status;
	
	@Column(name = "InputVoltage_SlrModule20")
	private Double inputVoltageSolarModule20;
	
	@Column(name = "InputCurrent_SlrModule20")
	private Double inputCurrentSolarModule20;
	
	@Column(name = "OutputVoltage_SlrModule20")
	private Double outputVoltageSolarModule20;
	
	@Column(name = "OutputCurrent_SlrModule20")
	private Double outputCurrentSolarModule20;
	
	@Column(name = "SolarModule20Status")
	private String solarModule20Status;
	
	@Column(name = "InputVoltage_SlrModule21")
	private Double inputVoltageSolarModule21;
	
	@Column(name = "InputCurrent_SlrModule21")
	private Double inputCurrentSolarModule21;
	
	@Column(name = "OutputVoltage_SlrModule21")
	private Double outputVoltageSolarModule21;
	
	@Column(name = "OutputCurrent_SlrModule21")
	private Double outputCurrentSolarModule21;
	
	@Column(name = "SolarModule21Status")
	private String solarModule21Status;
	
	@Column(name = "InputVoltage_SlrModule22")
	private Double inputVoltageSolarModule22;
	
	@Column(name = "InputCurrent_SlrModule22")
	private Double inputCurrentSolarModule22;
	
	@Column(name = "OutputVoltage_SlrModule22")
	private Double outputVoltageSolarModule22;
	
	@Column(name = "OutputCurrent_SlrModule22")
	private Double outputCurrentSolarModule22;
	
	@Column(name = "SolarModule22Status")
	private String solarModule22Status;
	
	
	@Column(name = "InputVoltage_SlrModule23")
	private Double inputVoltageSolarModule23;
	
	@Column(name = "InputCurrent_SlrModule23")
	private Double inputCurrentSolarModule23;
	
	@Column(name = "OutputVoltage_SlrModule23")
	private Double outputVoltageSolarModule23;
	
	@Column(name = "OutputCurrent_SlrModule23")
	private Double outputCurrentSolarModule23;
	
	@Column(name = "SolarModule23Status")
	private String solarModule23Status;
	
	@Column(name = "InputVoltage_SlrModule24")
	private Double inputVoltageSolarModule24;
	
	@Column(name = "InputCurrent_SlrModule24")
	private Double inputCurrentSolarModule24;
	
	@Column(name = "OutputVoltage_SlrModule24")
	private Double outputVoltageSolarModule24;
	
	@Column(name = "OutputCurrent_SlrModule24")
	private Double outputCurrentSolarModule24;
	
	@Column(name = "SolarModule24Status")
	private String solarModule24Status;
	
	@Column(name = "No_of_Solar_Module")
	private Integer numberOfSolarModule;
	
	@Column(name = "Solar_Input_Energy")
	private Double solarInputEnergy;	
	
	@Column(name = "Solar_Output_Energy")
	private Double solarOutputEnergy;
	
	@Column(name = "SolarRunHrs")
	private Double solarRunHours;
	
	@Column(name = "SolarMDGRunHrs")
	private Double solarMDGRunHours;
	
	@Column(name = "SolarDGRunHrs")
	private Double solarDGRunHours;
	
	@Column(name = "SolarBattRunHrs")
	private Double solarBatteryRunHours;
	
	@Column(name = "SolarTotalnputPower")
	private Double solarTotalInputPower;
	
	@Column(name = "SolarTotaOutputPower")
	private Double solarTotalOutputPower;
	
	@Column(name = "SysOutLoadStatus")
	private String sysOutLoadStatus;
	
	@Column(name = "MDGRunHrs")
	private Double mdgRunHour;
	
	@Column(name = "TeleRunHrs")
	private Double teleRunHours;
	
	@Column(name = "TeleEnergy")
	private Double teleEnergy;
	
	@Column(name = "CommunityLoad_R_Voltage")
	private Double communityLoadRVoltage;
	
	@Column(name = "CommunityLoad_Y_Voltage")
	private Double communityLoadYVoltage;
	
	@Column(name = "CommunityLoad_B_Voltage")
	private Double communityLoadBVoltage;
	
	@Column(name = "CommunityLoad_R_Current")
	private Double communityLoadRCurrent;
	
	@Column(name = "CommunityLoad_Y_Current")
	private Double communityLoadYCurrent;
	
	@Column(name = "CommunityLoad_B_Current")
	private Double communityLoadBCurrent;
	
	@Column(name = "CommunityLoad_R_PowerFactor")
	private Double communityLoadRPowerFactor;
	
	@Column(name = "CommunityLoad_Y_PowerFactor")
	private Double communityLoadYPowerFactor;
	
	@Column(name = "CommunityLoad_B_PowerFactor")
	private Double communityLoadBPowerFactor;
	
	@Column(name = "CommunityLoad_R_Power")
	private Double communityLoadRPower;
	
	@Column(name = "CommunityLoad_Y_Power")
	private Double communityLoadYPower;
	
	@Column(name = "CommunityLoad_B_Power")
	private Double communityLoadBPower;
	
	@Column(name = "CommunityLoad_Frequency")
	private Double communityLoadFrequency;
	
	@Column(name = "CommunityLoad_RunHrs")
	private Double communityLoadRunHours;
	
	@Column(name = "CommunityLoad_Energy")
	private Double communityLoadEnergy;
	
	@Column(name = "InverterInputVoltage_1")
	private Double inverterInputVoltage1;
	
	@Column(name = "InverterInputCurrent_1")
	private Double inverterInputCurrent1;
	
	@Column(name = "InverterOutVoltage_1")
	private Double inverterOutVoltage1;
	
	@Column(name = "InverterOutputCurrent_1")
	private Double inverterOutputCurrent1;
	
	@Column(name = "InverterOutputEnergy_1")
	private Double inverterOutputEnergy1;
	
	@Column(name = "InverterTemp_1")
	private Double inverterTemp1;
	
	@Column(name = "Ineverter_Status_1")
	private String ineverterStatus1;
	
	@Column(name = "InverterInputVoltage_2")
	private Double inverterInputVoltage2;
	
	@Column(name = "InverterInputCurrent_2")
	private Double inverterInputCurrent2;
	
	@Column(name = "InverterOutVoltage_2")
	private Double inverterOutVoltage2;
	
	@Column(name = "InverterOutputCurrent_2")
	private Double inverterOutputCurrent2;
	
	@Column(name = "InverterOutputEnergy_2")
	private Double inverterOutputEnergy2;
	
	@Column(name = "InverterTemp_2")
	private Double inverterTemp2;
	
	@Column(name = "Ineverter_Status_2")
	private String ineverterStatus2;
	
	
	@Column(name = "InverterInputVoltage_3")
	private Double inverterInputVoltage3;
	
	@Column(name = "InverterInputCurrent_3")
	private Double inverterInputCurrent3;
	
	@Column(name = "InverterOutVoltage_3")
	private Double inverterOutVoltage3;
	
	@Column(name = "InverterOutputCurrent_3")
	private Double inverterOutputCurrent3;
	
	@Column(name = "InverterOutputEnergy_3")
	private Double inverterOutputEnergy3;
	
	@Column(name = "InverterTemp_3")
	private Double inverterTemp3;
	
	@Column(name = "Ineverter_Status_3")
	private String ineverterStatus3;
	
	
	@Column(name = "InverterInputVoltage_4")
	private Double inverterInputVoltage4;
	
	@Column(name = "InverterInputCurrent_4")
	private Double inverterInputCurrent4;
	
	@Column(name = "InverterOutVoltage_4")
	private Double inverterOutVoltage4;
	
	@Column(name = "InverterOutputCurrent_4")
	private Double inverterOutputCurrent4;
	
	@Column(name = "InverterOutputEnergy_4")
	private Double inverterOutputEnergy4;
	
	@Column(name = "InverterTemp_4")
	private Double inverterTemp4;
	
	@Column(name = "Ineverter_Status_4")
	private String ineverterStatus4;
	
	
	@Column(name = "InverterInputVoltage_5")
	private Double inverterInputVoltage5;
	
	@Column(name = "InverterInputCurrent_5")
	private Double inverterInputCurrent5;
	
	@Column(name = "InverterOutVoltage_5")
	private Double inverterOutVoltage5;
	
	@Column(name = "InverterOutputCurrent_5")
	private Double inverterOutputCurrent5;
	
	@Column(name = "InverterOutputEnergy_5")
	private Double inverterOutputEnergy5;
	
	@Column(name = "InverterTemp_5")
	private Double inverterTemp5;
	
	@Column(name = "Ineverter_Status_5")
	private String ineverterStatus5;
	
	
	@Column(name = "InverterInputVoltage_6")
	private Double inverterInputVoltage6;
	
	@Column(name = "InverterInputCurrent_6")
	private Double inverterInputCurrent6;
	
	@Column(name = "InverterOutVoltage_6")
	private Double inverterOutVoltage6;
	
	@Column(name = "InverterOutputCurrent_6")
	private Double inverterOutputCurrent6;
	
	@Column(name = "InverterOutputEnergy_6")
	private Double inverterOutputEnergy6;
	
	@Column(name = "InverterTemp_6")
	private Double inverterTemp6;
	
	@Column(name = "Ineverter_Status_6")
	private String ineverterStatus6;
	
	
	@Column(name = "InverterInputVoltage_7")
	private Double inverterInputVoltage7;
	
	@Column(name = "InverterInputCurrent_7")
	private Double inverterInputCurrent7;
	
	@Column(name = "InverterOutVoltage_7")
	private Double inverterOutVoltage7;
	
	@Column(name = "InverterOutputCurrent_7")
	private Double inverterOutputCurrent7;
	
	@Column(name = "InverterOutputEnergy_7")
	private Double inverterOutputEnergy7;
	
	@Column(name = "InverterTemp_7")
	private Double inverterTemp7;
	
	@Column(name = "Ineverter_Status_7")
	private String ineverterStatus7;
	
	
	@Column(name = "InverterInputVoltage_8")
	private Double inverterInputVoltage8;
	
	@Column(name = "InverterInputCurrent_8")
	private Double inverterInputCurrent8;
	
	@Column(name = "InverterOutVoltage_8")
	private Double inverterOutVoltage8;
	
	@Column(name = "InverterOutputCurrent_8")
	private Double inverterOutputCurrent8;
	
	@Column(name = "InverterOutputEnergy_8")
	private Double inverterOutputEnergy8;
	
	@Column(name = "InverterTemp_8")
	private Double inverterTemp8;
	
	@Column(name = "Ineverter_Status_8")
	private String ineverterStatus8;
	
	
	@Column(name = "InverterInputVoltage_9")
	private Double inverterInputVoltage9;
	
	@Column(name = "InverterInputCurrent_9")
	private Double inverterInputCurrent9;
	
	@Column(name = "InverterOutVoltage_9")
	private Double inverterOutVoltage9;
	
	@Column(name = "InverterOutputCurrent_9")
	private Double inverterOutputCurrent9;
	
	@Column(name = "InverterOutputEnergy_9")
	private Double inverterOutputEnergy9;
	
	@Column(name = "InverterTemp_9")
	private Double inverterTemp9;
	
	@Column(name = "Ineverter_Status_9")
	private String ineverterStatus9;
	
	
	@Column(name = "InverterInputVoltage_10")
	private Double inverterInputVoltage10;
	
	@Column(name = "InverterInputCurrent_10")
	private Double inverterInputCurrent10;
	
	@Column(name = "InverterOutVoltage_10")
	private Double inverterOutVoltage10;
	
	@Column(name = "InverterOutputCurrent_10")
	private Double inverterOutputCurrent10;
	
	@Column(name = "InverterOutputEnergy_10")
	private Double inverterOutputEnergy10;
	
	@Column(name = "InverterTemp_10")
	private Double inverterTemp10;
	
	@Column(name = "Ineverter_Status_10")
	private String ineverterStatus10;
	
	@Column(name = "InverterInputVoltage_11")
	private Double inverterInputVoltage11;
	
	@Column(name = "InverterInputCurrent_11")
	private Double inverterInputCurrent11;
	
	@Column(name = "InverterOutVoltage_11")
	private Double inverterOutVoltage11;
	
	@Column(name = "InverterOutputCurrent_11")
	private Double inverterOutputCurrent11;
	
	@Column(name = "InverterOutputEnergy_11")
	private Double inverterOutputEnergy11;
	
	@Column(name = "InverterTemp_11")
	private Double inverterTemp11;
	
	@Column(name = "Ineverter_Status_11")
	private String ineverterStatus11;
	
	@Column(name = "InverterInputVoltage_12")
	private Double inverterInputVoltage12;
	
	@Column(name = "InverterInputCurrent_12")
	private Double inverterInputCurrent12;
	
	@Column(name = "InverterOutVoltage_12")
	private Double inverterOutVoltage12;
	
	@Column(name = "InverterOutputCurrent_12")
	private Double inverterOutputCurrent12;
	
	@Column(name = "InverterOutputEnergy_12")
	private Double inverterOutputEnergy12;
	
	@Column(name = "InverterTemp_12")
	private Double inverterTemp12;
	
	@Column(name = "Ineverter_Status_12")
	private String ineverterStatus12;
	
	@Column(name = "No_Of_Inverter_Module")
	private Integer numberOfInverter;
	
	@Column(name = "InverterRunHrs")
	private Double inverterRunHours;
	
	@Column(name = "InverterEnergy")
	private Double inverterEnergy;
	
	@Column(name = "InverterInputPower")
	private Double inverterInputPower;
	
	@Column(name = "InverterOutputPower")
	private Double inverterOutputPower;
	
	@Column(name = "ACTEL_R_Voltage")
	private Double actelRVoltage;
	
	@Column(name = "ACTEL_Y_Voltage")
	private Double actelYVoltage;
	
	@Column(name = "ACTEL_B_Voltage")
	private Double actelBVoltage;
	
	@Column(name = "ACTEL_R_Current")
	private Double actelRCurrent;
	
	@Column(name = "ACTEL_Y_Current")
	private Double actelYCurrent;
	
	@Column(name = "ACTEL_B_Current")
	private Double actelBCurrent;
	
	@Column(name = "ACTEL_R_PowerFactor")
	private Double actelRPowerFactor;
	
	@Column(name = "ACTEL_Y_PowerFactor")
	private Double actelYPowerFactor;
	
	@Column(name = "ACTEL_B_PowerFactor")
	private Double actelBPowerFactor;
	
	@Column(name = "ACTEL_R_Power")
	private Double actelRPower;
	
	@Column(name = "ACTEL_Y_Power")
	private Double actelYPower;
	
	@Column(name = "ACTEL_B_Power")
	private Double actelBPower;
	
	@Column(name = "ACTEL_Frequency")
	private Double actelFrequency;

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getSiteId() {
		return siteId;
	}

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

	public String getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(String updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getTranTime() {
		return tranTime;
	}

	public void setTranTime(String tranTime) {
		this.tranTime = tranTime;
	}

	public String getAlarm() {
		return alarm;
	}

	public void setAlarm(String alarm) {
		this.alarm = alarm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCommunication() {
		return communication;
	}

	public void setCommunication(String communication) {
		this.communication = communication;
	}

	public String getSysOutputLoadStatus() {
		return sysOutputLoadStatus;
	}

	public void setSysOutputLoadStatus(String sysOutputLoadStatus) {
		this.sysOutputLoadStatus = sysOutputLoadStatus;
	}

	public String getPowerSource() {
		return powerSource;
	}

	public void setPowerSource(String powerSource) {
		this.powerSource = powerSource;
	}

	public Double getSiteBatteryVolt() {
		return siteBatteryVolt;
	}

	public void setSiteBatteryVolt(Double siteBatteryVolt) {
		this.siteBatteryVolt = siteBatteryVolt;
	}

	public Integer getBatterySOC() {
		return batterySOC;
	}

	public void setBatterySOC(Integer batterySOC) {
		this.batterySOC = batterySOC;
	}

	public Double getOpco1LoadCurrent() {
		return opco1LoadCurrent;
	}

	public void setOpco1LoadCurrent(Double opco1LoadCurrent) {
		this.opco1LoadCurrent = opco1LoadCurrent;
	}

	public Double getOpco2LoadCurrent() {
		return opco2LoadCurrent;
	}

	public void setOpco2LoadCurrent(Double opco2LoadCurrent) {
		this.opco2LoadCurrent = opco2LoadCurrent;
	}

	public Double getOpco3LoadCurrent() {
		return opco3LoadCurrent;
	}

	public void setOpco3LoadCurrent(Double opco3LoadCurrent) {
		this.opco3LoadCurrent = opco3LoadCurrent;
	}

	public Double getOpco4LoadCurrent() {
		return opco4LoadCurrent;
	}

	public void setOpco4LoadCurrent(Double opco4LoadCurrent) {
		this.opco4LoadCurrent = opco4LoadCurrent;
	}

	public Double getOpco1Energy() {
		return opco1Energy;
	}

	public void setOpco1Energy(Double opco1Energy) {
		this.opco1Energy = opco1Energy;
	}

	public Double getOpco2Energy() {
		return opco2Energy;
	}

	public void setOpco2Energy(Double opco2Energy) {
		this.opco2Energy = opco2Energy;
	}

	public Double getOpco3Energy() {
		return opco3Energy;
	}

	public void setOpco3Energy(Double opco3Energy) {
		this.opco3Energy = opco3Energy;
	}

	public Double getOpco4Energy() {
		return opco4Energy;
	}

	public void setOpco4Energy(Double opco4Energy) {
		this.opco4Energy = opco4Energy;
	}

	public Double getBattery1Temp() {
		return battery1Temp;
	}

	public void setBattery1Temp(Double battery1Temp) {
		this.battery1Temp = battery1Temp;
	}

	public Double getBattery2Temp() {
		return battery2Temp;
	}

	public void setBattery2Temp(Double battery2Temp) {
		this.battery2Temp = battery2Temp;
	}

	public Double getBattery3Temp() {
		return battery3Temp;
	}

	public void setBattery3Temp(Double battery3Temp) {
		this.battery3Temp = battery3Temp;
	}

	public Double getBattery4Temp() {
		return battery4Temp;
	}

	public void setBattery4Temp(Double battery4Temp) {
		this.battery4Temp = battery4Temp;
	}

	public Integer getFuelLevel() {
		return fuelLevel;
	}

	public void setFuelLevel(Integer fuelLevel) {
		this.fuelLevel = fuelLevel;
	}

	public Integer getFuelLevelLtrs() {
		return fuelLevelLtrs;
	}

	public void setFuelLevelLtrs(Integer fuelLevelLtrs) {
		this.fuelLevelLtrs = fuelLevelLtrs;
	}

	public Integer getMdgRVolt() {
		return mdgRVolt;
	}

	public void setMdgRVolt(Integer mdgRVolt) {
		this.mdgRVolt = mdgRVolt;
	}

	public Integer getMdgYVolt() {
		return mdgYVolt;
	}

	public void setMdgYVolt(Integer mdgYVolt) {
		this.mdgYVolt = mdgYVolt;
	}

	public Integer getMdgBVolt() {
		return mdgBVolt;
	}

	public void setMdgBVolt(Integer mdgBVolt) {
		this.mdgBVolt = mdgBVolt;
	}

	public Double getMdgRAmp() {
		return mdgRAmp;
	}

	public void setMdgRAmp(Double mdgRAmp) {
		this.mdgRAmp = mdgRAmp;
	}

	public Double getMdgYAmp() {
		return mdgYAmp;
	}

	public void setMdgYAmp(Double mdgYAmp) {
		this.mdgYAmp = mdgYAmp;
	}

	public Double getMdgBAmp() {
		return mdgBAmp;
	}

	public void setMdgBAmp(Double mdgBAmp) {
		this.mdgBAmp = mdgBAmp;
	}

	public Double getMdgRPowerFactor() {
		return mdgRPowerFactor;
	}

	public void setMdgRPowerFactor(Double mdgRPowerFactor) {
		this.mdgRPowerFactor = mdgRPowerFactor;
	}

	public Double getMdgYPowerFactor() {
		return mdgYPowerFactor;
	}

	public void setMdgYPowerFactor(Double mdgYPowerFactor) {
		this.mdgYPowerFactor = mdgYPowerFactor;
	}

	public Double getMdgBPowerFactor() {
		return mdgBPowerFactor;
	}

	public void setMdgBPowerFactor(Double mdgBPowerFactor) {
		this.mdgBPowerFactor = mdgBPowerFactor;
	}

	public Double getMdgRPower() {
		return mdgRPower;
	}

	public void setMdgRPower(Double mdgRPower) {
		this.mdgRPower = mdgRPower;
	}

	public Double getMdgYPower() {
		return mdgYPower;
	}

	public void setMdgYPower(Double mdgYPower) {
		this.mdgYPower = mdgYPower;
	}

	public Double getMdgBPower() {
		return mdgBPower;
	}

	public void setMdgBPower(Double mdgBPower) {
		this.mdgBPower = mdgBPower;
	}

	public Double getMdgFrequency() {
		return mdgFrequency;
	}

	public void setMdgFrequency(Double mdgFrequency) {
		this.mdgFrequency = mdgFrequency;
	}

	public Integer getDgRVolt() {
		return dgRVolt;
	}

	public void setDgRVolt(Integer dgRVolt) {
		this.dgRVolt = dgRVolt;
	}

	public Integer getDgYVolt() {
		return dgYVolt;
	}

	public void setDgYVolt(Integer dgYVolt) {
		this.dgYVolt = dgYVolt;
	}

	public Integer getDgBVolt() {
		return dgBVolt;
	}

	public void setDgBVolt(Integer dgBVolt) {
		this.dgBVolt = dgBVolt;
	}

	public Double getDgRAmp() {
		return dgRAmp;
	}

	public void setDgRAmp(Double dgRAmp) {
		this.dgRAmp = dgRAmp;
	}

	public Double getDgYAmp() {
		return dgYAmp;
	}

	public void setDgYAmp(Double dgYAmp) {
		this.dgYAmp = dgYAmp;
	}

	public Double getDgBAmp() {
		return dgBAmp;
	}

	public void setDgBAmp(Double dgBAmp) {
		this.dgBAmp = dgBAmp;
	}

	public Double getDgRPowerFactor() {
		return dgRPowerFactor;
	}

	public void setDgRPowerFactor(Double dgRPowerFactor) {
		this.dgRPowerFactor = dgRPowerFactor;
	}

	public Double getDgYPowerFactor() {
		return dgYPowerFactor;
	}

	public void setDgYPowerFactor(Double dgYPowerFactor) {
		this.dgYPowerFactor = dgYPowerFactor;
	}

	public Double getDgBPowerFactor() {
		return dgBPowerFactor;
	}

	public void setDgBPowerFactor(Double dgBPowerFactor) {
		this.dgBPowerFactor = dgBPowerFactor;
	}

	public Double getDgRPower() {
		return dgRPower;
	}

	public void setDgRPower(Double dgRPower) {
		this.dgRPower = dgRPower;
	}

	public Double getDgYPower() {
		return dgYPower;
	}

	public void setDgYPower(Double dgYPower) {
		this.dgYPower = dgYPower;
	}

	public Double getDgBPower() {
		return dgBPower;
	}

	public void setDgBPower(Double dgBPower) {
		this.dgBPower = dgBPower;
	}

	public Double getDgFrequency() {
		return dgFrequency;
	}

	public void setDgFrequency(Double dgFrequency) {
		this.dgFrequency = dgFrequency;
	}

	public Double getDgBatteryVoltage() {
		return dgBatteryVoltage;
	}

	public void setDgBatteryVoltage(Double dgBatteryVoltage) {
		this.dgBatteryVoltage = dgBatteryVoltage;
	}

	public Integer getDgTankCapacity() {
		return dgTankCapacity;
	}

	public void setDgTankCapacity(Integer dgTankCapacity) {
		this.dgTankCapacity = dgTankCapacity;
	}

	public Double getBatterChargingCurrent() {
		return batterChargingCurrent;
	}

	public void setBatterChargingCurrent(Double batterChargingCurrent) {
		this.batterChargingCurrent = batterChargingCurrent;
	}

	public Double getBatterDisChargingCurrent() {
		return batterDisChargingCurrent;
	}

	public void setBatterDisChargingCurrent(Double batterDisChargingCurrent) {
		this.batterDisChargingCurrent = batterDisChargingCurrent;
	}

	public Integer getBatteryCycleCount() {
		return batteryCycleCount;
	}

	public void setBatteryCycleCount(Integer batteryCycleCount) {
		this.batteryCycleCount = batteryCycleCount;
	}

	public Integer getBatteryCapacityAH() {
		return batteryCapacityAH;
	}

	public void setBatteryCapacityAH(Integer batteryCapacityAH) {
		this.batteryCapacityAH = batteryCapacityAH;
	}

	public Double getBatterNextFullChargeTime() {
		return batterNextFullChargeTime;
	}

	public void setBatterNextFullChargeTime(Double batterNextFullChargeTime) {
		this.batterNextFullChargeTime = batterNextFullChargeTime;
	}

	public Integer getNumberOfBatteries() {
		return numberOfBatteries;
	}

	public void setNumberOfBatteries(Integer numberOfBatteries) {
		this.numberOfBatteries = numberOfBatteries;
	}

	public Double getMdgRunHours() {
		return mdgRunHours;
	}

	public void setMdgRunHours(Double mdgRunHours) {
		this.mdgRunHours = mdgRunHours;
	}

	public Double getDgRunHours() {
		return dgRunHours;
	}

	public void setDgRunHours(Double dgRunHours) {
		this.dgRunHours = dgRunHours;
	}

	public Double getBatteryRunHours() {
		return batteryRunHours;
	}

	public void setBatteryRunHours(Double batteryRunHours) {
		this.batteryRunHours = batteryRunHours;
	}

	public Double getMdgEnergy() {
		return mdgEnergy;
	}

	public void setMdgEnergy(Double mdgEnergy) {
		this.mdgEnergy = mdgEnergy;
	}

	public Double getDgEnergy() {
		return dgEnergy;
	}

	public void setDgEnergy(Double dgEnergy) {
		this.dgEnergy = dgEnergy;
	}

	public Double getBatteryDisEnergy() {
		return batteryDisEnergy;
	}

	public void setBatteryDisEnergy(Double batteryDisEnergy) {
		this.batteryDisEnergy = batteryDisEnergy;
	}

	public Double getBatteryChargingEnergy() {
		return batteryChargingEnergy;
	}

	public void setBatteryChargingEnergy(Double batteryChargingEnergy) {
		this.batteryChargingEnergy = batteryChargingEnergy;
	}

	public Integer getRectInputRVoltage() {
		return rectInputRVoltage;
	}

	public void setRectInputRVoltage(Integer rectInputRVoltage) {
		this.rectInputRVoltage = rectInputRVoltage;
	}

	public Integer getRectInputYVoltage() {
		return rectInputYVoltage;
	}

	public void setRectInputYVoltage(Integer rectInputYVoltage) {
		this.rectInputYVoltage = rectInputYVoltage;
	}

	public Integer getRectInputBVoltage() {
		return rectInputBVoltage;
	}

	public void setRectInputBVoltage(Integer rectInputBVoltage) {
		this.rectInputBVoltage = rectInputBVoltage;
	}

	public Double getRectInputRCurrent() {
		return rectInputRCurrent;
	}

	public void setRectInputRCurrent(Double rectInputRCurrent) {
		this.rectInputRCurrent = rectInputRCurrent;
	}

	public Double getRectInputYCurrent() {
		return rectInputYCurrent;
	}

	public void setRectInputYCurrent(Double rectInputYCurrent) {
		this.rectInputYCurrent = rectInputYCurrent;
	}

	public Double getRectInputBCurrent() {
		return rectInputBCurrent;
	}

	public void setRectInputBCurrent(Double rectInputBCurrent) {
		this.rectInputBCurrent = rectInputBCurrent;
	}

	public Double getRectOutputVoltage() {
		return rectOutputVoltage;
	}

	public void setRectOutputVoltage(Double rectOutputVoltage) {
		this.rectOutputVoltage = rectOutputVoltage;
	}

	public Integer getNumberOfRectfrs() {
		return numberOfRectfrs;
	}

	public void setNumberOfRectfrs(Integer numberOfRectfrs) {
		this.numberOfRectfrs = numberOfRectfrs;
	}

	public Double getTotalRectOutputCurrent() {
		return totalRectOutputCurrent;
	}

	public void setTotalRectOutputCurrent(Double totalRectOutputCurrent) {
		this.totalRectOutputCurrent = totalRectOutputCurrent;
	}

	public Double getTotalDCLoadCurrent() {
		return totalDCLoadCurrent;
	}

	public void setTotalDCLoadCurrent(Double totalDCLoadCurrent) {
		this.totalDCLoadCurrent = totalDCLoadCurrent;
	}

	public Double getTotalDCLoadEnergy() {
		return totalDCLoadEnergy;
	}

	public void setTotalDCLoadEnergy(Double totalDCLoadEnergy) {
		this.totalDCLoadEnergy = totalDCLoadEnergy;
	}

	public Double getInputVoltageSolarModule1() {
		return inputVoltageSolarModule1;
	}

	public void setInputVoltageSolarModule1(Double inputVoltageSolarModule1) {
		this.inputVoltageSolarModule1 = inputVoltageSolarModule1;
	}

	public Double getInputCurrentSolarModule1() {
		return inputCurrentSolarModule1;
	}

	public void setInputCurrentSolarModule1(Double inputCurrentSolarModule1) {
		this.inputCurrentSolarModule1 = inputCurrentSolarModule1;
	}

	public Double getInputPowerSolarModule1() {
		return inputPowerSolarModule1;
	}

	public void setInputPowerSolarModule1(Double inputPowerSolarModule1) {
		this.inputPowerSolarModule1 = inputPowerSolarModule1;
	}

	public Double getOutputVoltageSolarModule1() {
		return outputVoltageSolarModule1;
	}

	public void setOutputVoltageSolarModule1(Double outputVoltageSolarModule1) {
		this.outputVoltageSolarModule1 = outputVoltageSolarModule1;
	}

	public Double getOutputCurrentSolarModule1() {
		return outputCurrentSolarModule1;
	}

	public void setOutputCurrentSolarModule1(Double outputCurrentSolarModule1) {
		this.outputCurrentSolarModule1 = outputCurrentSolarModule1;
	}

	public Double getOutputPowerSolarModule1() {
		return outputPowerSolarModule1;
	}

	public void setOutputPowerSolarModule1(Double outputPowerSolarModule1) {
		this.outputPowerSolarModule1 = outputPowerSolarModule1;
	}

	public String getSolarModule1Status() {
		return solarModule1Status;
	}

	public void setSolarModule1Status(String solarModule1Status) {
		this.solarModule1Status = solarModule1Status;
	}

	public Double getInputVoltageSolarModule2() {
		return inputVoltageSolarModule2;
	}

	public void setInputVoltageSolarModule2(Double inputVoltageSolarModule2) {
		this.inputVoltageSolarModule2 = inputVoltageSolarModule2;
	}

	public Double getInputCurrentSolarModule2() {
		return inputCurrentSolarModule2;
	}

	public void setInputCurrentSolarModule2(Double inputCurrentSolarModule2) {
		this.inputCurrentSolarModule2 = inputCurrentSolarModule2;
	}

	public Double getInputPowerSolarModule2() {
		return inputPowerSolarModule2;
	}

	public void setInputPowerSolarModule2(Double inputPowerSolarModule2) {
		this.inputPowerSolarModule2 = inputPowerSolarModule2;
	}

	public Double getOutputVoltageSolarModule2() {
		return outputVoltageSolarModule2;
	}

	public void setOutputVoltageSolarModule2(Double outputVoltageSolarModule2) {
		this.outputVoltageSolarModule2 = outputVoltageSolarModule2;
	}

	public Double getOutputCurrentSolarModule2() {
		return outputCurrentSolarModule2;
	}

	public void setOutputCurrentSolarModule2(Double outputCurrentSolarModule2) {
		this.outputCurrentSolarModule2 = outputCurrentSolarModule2;
	}

	public Double getOutputPowerSolarModule2() {
		return outputPowerSolarModule2;
	}

	public void setOutputPowerSolarModule2(Double outputPowerSolarModule2) {
		this.outputPowerSolarModule2 = outputPowerSolarModule2;
	}

	public String getSolarModule2Status() {
		return solarModule2Status;
	}

	public void setSolarModule2Status(String solarModule2Status) {
		this.solarModule2Status = solarModule2Status;
	}

	public Double getInputVoltageSolarModule3() {
		return inputVoltageSolarModule3;
	}

	public void setInputVoltageSolarModule3(Double inputVoltageSolarModule3) {
		this.inputVoltageSolarModule3 = inputVoltageSolarModule3;
	}

	public Double getInputCurrentSolarModule3() {
		return inputCurrentSolarModule3;
	}

	public void setInputCurrentSolarModule3(Double inputCurrentSolarModule3) {
		this.inputCurrentSolarModule3 = inputCurrentSolarModule3;
	}

	public Double getInputPowerSolarModule3() {
		return inputPowerSolarModule3;
	}

	public void setInputPowerSolarModule3(Double inputPowerSolarModule3) {
		this.inputPowerSolarModule3 = inputPowerSolarModule3;
	}

	public Double getOutputVoltageSolarModule3() {
		return outputVoltageSolarModule3;
	}

	public void setOutputVoltageSolarModule3(Double outputVoltageSolarModule3) {
		this.outputVoltageSolarModule3 = outputVoltageSolarModule3;
	}

	public Double getOutputCurrentSolarModule3() {
		return outputCurrentSolarModule3;
	}

	public void setOutputCurrentSolarModule3(Double outputCurrentSolarModule3) {
		this.outputCurrentSolarModule3 = outputCurrentSolarModule3;
	}

	public Double getOutputPowerSolarModule3() {
		return outputPowerSolarModule3;
	}

	public void setOutputPowerSolarModule3(Double outputPowerSolarModule3) {
		this.outputPowerSolarModule3 = outputPowerSolarModule3;
	}

	public String getSolarModule3Status() {
		return solarModule3Status;
	}

	public void setSolarModule3Status(String solarModule3Status) {
		this.solarModule3Status = solarModule3Status;
	}

	public Double getInputVoltageSolarModule4() {
		return inputVoltageSolarModule4;
	}

	public void setInputVoltageSolarModule4(Double inputVoltageSolarModule4) {
		this.inputVoltageSolarModule4 = inputVoltageSolarModule4;
	}

	public Double getInputCurrentSolarModule4() {
		return inputCurrentSolarModule4;
	}

	public void setInputCurrentSolarModule4(Double inputCurrentSolarModule4) {
		this.inputCurrentSolarModule4 = inputCurrentSolarModule4;
	}

	public Double getInputPowerSolarModule4() {
		return inputPowerSolarModule4;
	}

	public void setInputPowerSolarModule4(Double inputPowerSolarModule4) {
		this.inputPowerSolarModule4 = inputPowerSolarModule4;
	}

	public Double getOutputVoltageSolarModule4() {
		return outputVoltageSolarModule4;
	}

	public void setOutputVoltageSolarModule4(Double outputVoltageSolarModule4) {
		this.outputVoltageSolarModule4 = outputVoltageSolarModule4;
	}

	public Double getOutputCurrentSolarModule4() {
		return outputCurrentSolarModule4;
	}

	public void setOutputCurrentSolarModule4(Double outputCurrentSolarModule4) {
		this.outputCurrentSolarModule4 = outputCurrentSolarModule4;
	}

	public Double getOutputPowerSolarModule4() {
		return outputPowerSolarModule4;
	}

	public void setOutputPowerSolarModule4(Double outputPowerSolarModule4) {
		this.outputPowerSolarModule4 = outputPowerSolarModule4;
	}

	public String getSolarModule4Status() {
		return solarModule4Status;
	}

	public void setSolarModule4Status(String solarModule4Status) {
		this.solarModule4Status = solarModule4Status;
	}

	public Double getInputVoltageSolarModule5() {
		return inputVoltageSolarModule5;
	}

	public void setInputVoltageSolarModule5(Double inputVoltageSolarModule5) {
		this.inputVoltageSolarModule5 = inputVoltageSolarModule5;
	}

	public Double getInputCurrentSolarModule5() {
		return inputCurrentSolarModule5;
	}

	public void setInputCurrentSolarModule5(Double inputCurrentSolarModule5) {
		this.inputCurrentSolarModule5 = inputCurrentSolarModule5;
	}

	public Double getInputPowerSolarModule5() {
		return inputPowerSolarModule5;
	}

	public void setInputPowerSolarModule5(Double inputPowerSolarModule5) {
		this.inputPowerSolarModule5 = inputPowerSolarModule5;
	}

	public Double getOutputVoltageSolarModule5() {
		return outputVoltageSolarModule5;
	}

	public void setOutputVoltageSolarModule5(Double outputVoltageSolarModule5) {
		this.outputVoltageSolarModule5 = outputVoltageSolarModule5;
	}

	public Double getOutputCurrentSolarModule5() {
		return outputCurrentSolarModule5;
	}

	public void setOutputCurrentSolarModule5(Double outputCurrentSolarModule5) {
		this.outputCurrentSolarModule5 = outputCurrentSolarModule5;
	}

	public Double getOutputPowerSolarModule5() {
		return outputPowerSolarModule5;
	}

	public void setOutputPowerSolarModule5(Double outputPowerSolarModule5) {
		this.outputPowerSolarModule5 = outputPowerSolarModule5;
	}

	public String getSolarModule5Status() {
		return solarModule5Status;
	}

	public void setSolarModule5Status(String solarModule5Status) {
		this.solarModule5Status = solarModule5Status;
	}

	public Double getInputVoltageSolarModule6() {
		return inputVoltageSolarModule6;
	}

	public void setInputVoltageSolarModule6(Double inputVoltageSolarModule6) {
		this.inputVoltageSolarModule6 = inputVoltageSolarModule6;
	}

	public Double getInputCurrentSolarModule6() {
		return inputCurrentSolarModule6;
	}

	public void setInputCurrentSolarModule6(Double inputCurrentSolarModule6) {
		this.inputCurrentSolarModule6 = inputCurrentSolarModule6;
	}

	public Double getInputPowerSolarModule6() {
		return inputPowerSolarModule6;
	}

	public void setInputPowerSolarModule6(Double inputPowerSolarModule6) {
		this.inputPowerSolarModule6 = inputPowerSolarModule6;
	}

	public Double getOutputVoltageSolarModule6() {
		return outputVoltageSolarModule6;
	}

	public void setOutputVoltageSolarModule6(Double outputVoltageSolarModule6) {
		this.outputVoltageSolarModule6 = outputVoltageSolarModule6;
	}

	public Double getOutputCurrentSolarModule6() {
		return outputCurrentSolarModule6;
	}

	public void setOutputCurrentSolarModule6(Double outputCurrentSolarModule6) {
		this.outputCurrentSolarModule6 = outputCurrentSolarModule6;
	}

	public Double getOutputPowerSolarModule6() {
		return outputPowerSolarModule6;
	}

	public void setOutputPowerSolarModule6(Double outputPowerSolarModule6) {
		this.outputPowerSolarModule6 = outputPowerSolarModule6;
	}

	public String getSolarModule6Status() {
		return solarModule6Status;
	}

	public void setSolarModule6Status(String solarModule6Status) {
		this.solarModule6Status = solarModule6Status;
	}

	public Double getInputVoltageSolarModule7() {
		return inputVoltageSolarModule7;
	}

	public void setInputVoltageSolarModule7(Double inputVoltageSolarModule7) {
		this.inputVoltageSolarModule7 = inputVoltageSolarModule7;
	}

	public Double getInputCurrentSolarModule7() {
		return inputCurrentSolarModule7;
	}

	public void setInputCurrentSolarModule7(Double inputCurrentSolarModule7) {
		this.inputCurrentSolarModule7 = inputCurrentSolarModule7;
	}

	public Double getInputPowerSolarModule7() {
		return inputPowerSolarModule7;
	}

	public void setInputPowerSolarModule7(Double inputPowerSolarModule7) {
		this.inputPowerSolarModule7 = inputPowerSolarModule7;
	}

	public Double getOutputVoltageSolarModule7() {
		return outputVoltageSolarModule7;
	}

	public void setOutputVoltageSolarModule7(Double outputVoltageSolarModule7) {
		this.outputVoltageSolarModule7 = outputVoltageSolarModule7;
	}

	public Double getOutputCurrentSolarModule7() {
		return outputCurrentSolarModule7;
	}

	public void setOutputCurrentSolarModule7(Double outputCurrentSolarModule7) {
		this.outputCurrentSolarModule7 = outputCurrentSolarModule7;
	}

	public Double getOutputPowerSolarModule7() {
		return outputPowerSolarModule7;
	}

	public void setOutputPowerSolarModule7(Double outputPowerSolarModule7) {
		this.outputPowerSolarModule7 = outputPowerSolarModule7;
	}

	public String getSolarModule7Status() {
		return solarModule7Status;
	}

	public void setSolarModule7Status(String solarModule7Status) {
		this.solarModule7Status = solarModule7Status;
	}

	public Double getInputVoltageSolarModule8() {
		return inputVoltageSolarModule8;
	}

	public void setInputVoltageSolarModule8(Double inputVoltageSolarModule8) {
		this.inputVoltageSolarModule8 = inputVoltageSolarModule8;
	}

	public Double getInputCurrentSolarModule8() {
		return inputCurrentSolarModule8;
	}

	public void setInputCurrentSolarModule8(Double inputCurrentSolarModule8) {
		this.inputCurrentSolarModule8 = inputCurrentSolarModule8;
	}

	public Double getInputPowerSolarModule8() {
		return inputPowerSolarModule8;
	}

	public void setInputPowerSolarModule8(Double inputPowerSolarModule8) {
		this.inputPowerSolarModule8 = inputPowerSolarModule8;
	}

	public Double getOutputVoltageSolarModule8() {
		return outputVoltageSolarModule8;
	}

	public void setOutputVoltageSolarModule8(Double outputVoltageSolarModule8) {
		this.outputVoltageSolarModule8 = outputVoltageSolarModule8;
	}

	public Double getOutputCurrentSolarModule8() {
		return outputCurrentSolarModule8;
	}

	public void setOutputCurrentSolarModule8(Double outputCurrentSolarModule8) {
		this.outputCurrentSolarModule8 = outputCurrentSolarModule8;
	}

	public Double getOutputPowerSolarModule8() {
		return outputPowerSolarModule8;
	}

	public void setOutputPowerSolarModule8(Double outputPowerSolarModule8) {
		this.outputPowerSolarModule8 = outputPowerSolarModule8;
	}

	public String getSolarModule8Status() {
		return solarModule8Status;
	}

	public void setSolarModule8Status(String solarModule8Status) {
		this.solarModule8Status = solarModule8Status;
	}

	public Double getInputVoltageSolarModule9() {
		return inputVoltageSolarModule9;
	}

	public void setInputVoltageSolarModule9(Double inputVoltageSolarModule9) {
		this.inputVoltageSolarModule9 = inputVoltageSolarModule9;
	}

	public Double getInputCurrentSolarModule9() {
		return inputCurrentSolarModule9;
	}

	public void setInputCurrentSolarModule9(Double inputCurrentSolarModule9) {
		this.inputCurrentSolarModule9 = inputCurrentSolarModule9;
	}

	public Double getInputPowerSolarModule9() {
		return inputPowerSolarModule9;
	}

	public void setInputPowerSolarModule9(Double inputPowerSolarModule9) {
		this.inputPowerSolarModule9 = inputPowerSolarModule9;
	}

	public Double getOutputVoltageSolarModule9() {
		return outputVoltageSolarModule9;
	}

	public void setOutputVoltageSolarModule9(Double outputVoltageSolarModule9) {
		this.outputVoltageSolarModule9 = outputVoltageSolarModule9;
	}

	public Double getOutputCurrentSolarModule9() {
		return outputCurrentSolarModule9;
	}

	public void setOutputCurrentSolarModule9(Double outputCurrentSolarModule9) {
		this.outputCurrentSolarModule9 = outputCurrentSolarModule9;
	}

	public Double getOutputPowerSolarModule9() {
		return outputPowerSolarModule9;
	}

	public void setOutputPowerSolarModule9(Double outputPowerSolarModule9) {
		this.outputPowerSolarModule9 = outputPowerSolarModule9;
	}

	public String getSolarModule9Status() {
		return solarModule9Status;
	}

	public void setSolarModule9Status(String solarModule9Status) {
		this.solarModule9Status = solarModule9Status;
	}

	public Double getInputVoltageSolarModule10() {
		return inputVoltageSolarModule10;
	}

	public void setInputVoltageSolarModule10(Double inputVoltageSolarModule10) {
		this.inputVoltageSolarModule10 = inputVoltageSolarModule10;
	}

	public Double getInputCurrentSolarModule10() {
		return inputCurrentSolarModule10;
	}

	public void setInputCurrentSolarModule10(Double inputCurrentSolarModule10) {
		this.inputCurrentSolarModule10 = inputCurrentSolarModule10;
	}

	public Double getInputPowerSolarModule10() {
		return inputPowerSolarModule10;
	}

	public void setInputPowerSolarModule10(Double inputPowerSolarModule10) {
		this.inputPowerSolarModule10 = inputPowerSolarModule10;
	}

	public Double getOutputVoltageSolarModule10() {
		return outputVoltageSolarModule10;
	}

	public void setOutputVoltageSolarModule10(Double outputVoltageSolarModule10) {
		this.outputVoltageSolarModule10 = outputVoltageSolarModule10;
	}

	public Double getOutputCurrentSolarModule10() {
		return outputCurrentSolarModule10;
	}

	public void setOutputCurrentSolarModule10(Double outputCurrentSolarModule10) {
		this.outputCurrentSolarModule10 = outputCurrentSolarModule10;
	}

	public Double getOutputPowerSolarModule10() {
		return outputPowerSolarModule10;
	}

	public void setOutputPowerSolarModule10(Double outputPowerSolarModule10) {
		this.outputPowerSolarModule10 = outputPowerSolarModule10;
	}

	public String getSolarModule10Status() {
		return solarModule10Status;
	}

	public void setSolarModule10Status(String solarModule10Status) {
		this.solarModule10Status = solarModule10Status;
	}

	public Double getInputVoltageSolarModule11() {
		return inputVoltageSolarModule11;
	}

	public void setInputVoltageSolarModule11(Double inputVoltageSolarModule11) {
		this.inputVoltageSolarModule11 = inputVoltageSolarModule11;
	}

	public Double getInputCurrentSolarModule11() {
		return inputCurrentSolarModule11;
	}

	public void setInputCurrentSolarModule11(Double inputCurrentSolarModule11) {
		this.inputCurrentSolarModule11 = inputCurrentSolarModule11;
	}

	public Double getInputPowerSolarModule11() {
		return inputPowerSolarModule11;
	}

	public void setInputPowerSolarModule11(Double inputPowerSolarModule11) {
		this.inputPowerSolarModule11 = inputPowerSolarModule11;
	}

	public Double getOutputVoltageSolarModule11() {
		return outputVoltageSolarModule11;
	}

	public void setOutputVoltageSolarModule11(Double outputVoltageSolarModule11) {
		this.outputVoltageSolarModule11 = outputVoltageSolarModule11;
	}

	public Double getOutputCurrentSolarModule11() {
		return outputCurrentSolarModule11;
	}

	public void setOutputCurrentSolarModule11(Double outputCurrentSolarModule11) {
		this.outputCurrentSolarModule11 = outputCurrentSolarModule11;
	}

	public Double getOutputPowerSolarModule11() {
		return outputPowerSolarModule11;
	}

	public void setOutputPowerSolarModule11(Double outputPowerSolarModule11) {
		this.outputPowerSolarModule11 = outputPowerSolarModule11;
	}

	public String getSolarModule11Status() {
		return solarModule11Status;
	}

	public void setSolarModule11Status(String solarModule11Status) {
		this.solarModule11Status = solarModule11Status;
	}

	public Double getInputVoltageSolarModule12() {
		return inputVoltageSolarModule12;
	}

	public void setInputVoltageSolarModule12(Double inputVoltageSolarModule12) {
		this.inputVoltageSolarModule12 = inputVoltageSolarModule12;
	}

	public Double getInputCurrentSolarModule12() {
		return inputCurrentSolarModule12;
	}

	public void setInputCurrentSolarModule12(Double inputCurrentSolarModule12) {
		this.inputCurrentSolarModule12 = inputCurrentSolarModule12;
	}

	public Double getInputPowerSolarModule12() {
		return inputPowerSolarModule12;
	}

	public void setInputPowerSolarModule12(Double inputPowerSolarModule12) {
		this.inputPowerSolarModule12 = inputPowerSolarModule12;
	}

	public Double getOutputVoltageSolarModule12() {
		return outputVoltageSolarModule12;
	}

	public void setOutputVoltageSolarModule12(Double outputVoltageSolarModule12) {
		this.outputVoltageSolarModule12 = outputVoltageSolarModule12;
	}

	public Double getOutputCurrentSolarModule12() {
		return outputCurrentSolarModule12;
	}

	public void setOutputCurrentSolarModule12(Double outputCurrentSolarModule12) {
		this.outputCurrentSolarModule12 = outputCurrentSolarModule12;
	}

	public Double getOutputPowerSolarModule12() {
		return outputPowerSolarModule12;
	}

	public void setOutputPowerSolarModule12(Double outputPowerSolarModule12) {
		this.outputPowerSolarModule12 = outputPowerSolarModule12;
	}

	public String getSolarModule12Status() {
		return solarModule12Status;
	}

	public void setSolarModule12Status(String solarModule12Status) {
		this.solarModule12Status = solarModule12Status;
	}

	public Double getInputVoltageSolarModule13() {
		return inputVoltageSolarModule13;
	}

	public void setInputVoltageSolarModule13(Double inputVoltageSolarModule13) {
		this.inputVoltageSolarModule13 = inputVoltageSolarModule13;
	}

	public Double getInputCurrentSolarModule13() {
		return inputCurrentSolarModule13;
	}

	public void setInputCurrentSolarModule13(Double inputCurrentSolarModule13) {
		this.inputCurrentSolarModule13 = inputCurrentSolarModule13;
	}

	public Double getOutputVoltageSolarModule13() {
		return outputVoltageSolarModule13;
	}

	public void setOutputVoltageSolarModule13(Double outputVoltageSolarModule13) {
		this.outputVoltageSolarModule13 = outputVoltageSolarModule13;
	}

	public Double getOutputCurrentSolarModule13() {
		return outputCurrentSolarModule13;
	}

	public void setOutputCurrentSolarModule13(Double outputCurrentSolarModule13) {
		this.outputCurrentSolarModule13 = outputCurrentSolarModule13;
	}

	public String getSolarModule13Status() {
		return solarModule13Status;
	}

	public void setSolarModule13Status(String solarModule13Status) {
		this.solarModule13Status = solarModule13Status;
	}

	public Double getInputVoltageSolarModule14() {
		return inputVoltageSolarModule14;
	}

	public void setInputVoltageSolarModule14(Double inputVoltageSolarModule14) {
		this.inputVoltageSolarModule14 = inputVoltageSolarModule14;
	}

	public Double getInputCurrentSolarModule14() {
		return inputCurrentSolarModule14;
	}

	public void setInputCurrentSolarModule14(Double inputCurrentSolarModule14) {
		this.inputCurrentSolarModule14 = inputCurrentSolarModule14;
	}

	public Double getOutputVoltageSolarModule14() {
		return outputVoltageSolarModule14;
	}

	public void setOutputVoltageSolarModule14(Double outputVoltageSolarModule14) {
		this.outputVoltageSolarModule14 = outputVoltageSolarModule14;
	}

	public Double getOutputCurrentSolarModule14() {
		return outputCurrentSolarModule14;
	}

	public void setOutputCurrentSolarModule14(Double outputCurrentSolarModule14) {
		this.outputCurrentSolarModule14 = outputCurrentSolarModule14;
	}

	public String getSolarModule14Status() {
		return solarModule14Status;
	}

	public void setSolarModule14Status(String solarModule14Status) {
		this.solarModule14Status = solarModule14Status;
	}

	public Double getInputVoltageSolarModule15() {
		return inputVoltageSolarModule15;
	}

	public void setInputVoltageSolarModule15(Double inputVoltageSolarModule15) {
		this.inputVoltageSolarModule15 = inputVoltageSolarModule15;
	}

	public Double getInputCurrentSolarModule15() {
		return inputCurrentSolarModule15;
	}

	public void setInputCurrentSolarModule15(Double inputCurrentSolarModule15) {
		this.inputCurrentSolarModule15 = inputCurrentSolarModule15;
	}

	public Double getOutputVoltageSolarModule15() {
		return outputVoltageSolarModule15;
	}

	public void setOutputVoltageSolarModule15(Double outputVoltageSolarModule15) {
		this.outputVoltageSolarModule15 = outputVoltageSolarModule15;
	}

	public Double getOutputCurrentSolarModule15() {
		return outputCurrentSolarModule15;
	}

	public void setOutputCurrentSolarModule15(Double outputCurrentSolarModule15) {
		this.outputCurrentSolarModule15 = outputCurrentSolarModule15;
	}

	public String getSolarModule15Status() {
		return solarModule15Status;
	}

	public void setSolarModule15Status(String solarModule15Status) {
		this.solarModule15Status = solarModule15Status;
	}

	public Double getInputVoltageSolarModule16() {
		return inputVoltageSolarModule16;
	}

	public void setInputVoltageSolarModule16(Double inputVoltageSolarModule16) {
		this.inputVoltageSolarModule16 = inputVoltageSolarModule16;
	}

	public Double getInputCurrentSolarModule16() {
		return inputCurrentSolarModule16;
	}

	public void setInputCurrentSolarModule16(Double inputCurrentSolarModule16) {
		this.inputCurrentSolarModule16 = inputCurrentSolarModule16;
	}

	public Double getOutputVoltageSolarModule16() {
		return outputVoltageSolarModule16;
	}

	public void setOutputVoltageSolarModule16(Double outputVoltageSolarModule16) {
		this.outputVoltageSolarModule16 = outputVoltageSolarModule16;
	}

	public Double getOutputCurrentSolarModule16() {
		return outputCurrentSolarModule16;
	}

	public void setOutputCurrentSolarModule16(Double outputCurrentSolarModule16) {
		this.outputCurrentSolarModule16 = outputCurrentSolarModule16;
	}

	public String getSolarModule16Status() {
		return solarModule16Status;
	}

	public void setSolarModule16Status(String solarModule16Status) {
		this.solarModule16Status = solarModule16Status;
	}

	public Double getInputVoltageSolarModule17() {
		return inputVoltageSolarModule17;
	}

	public void setInputVoltageSolarModule17(Double inputVoltageSolarModule17) {
		this.inputVoltageSolarModule17 = inputVoltageSolarModule17;
	}

	public Double getInputCurrentSolarModule17() {
		return inputCurrentSolarModule17;
	}

	public void setInputCurrentSolarModule17(Double inputCurrentSolarModule17) {
		this.inputCurrentSolarModule17 = inputCurrentSolarModule17;
	}

	public Double getOutputVoltageSolarModule17() {
		return outputVoltageSolarModule17;
	}

	public void setOutputVoltageSolarModule17(Double outputVoltageSolarModule17) {
		this.outputVoltageSolarModule17 = outputVoltageSolarModule17;
	}

	public Double getOutputCurrentSolarModule17() {
		return outputCurrentSolarModule17;
	}

	public void setOutputCurrentSolarModule17(Double outputCurrentSolarModule17) {
		this.outputCurrentSolarModule17 = outputCurrentSolarModule17;
	}

	public String getSolarModule17Status() {
		return solarModule17Status;
	}

	public void setSolarModule17Status(String solarModule17Status) {
		this.solarModule17Status = solarModule17Status;
	}

	public Double getInputVoltageSolarModule18() {
		return inputVoltageSolarModule18;
	}

	public void setInputVoltageSolarModule18(Double inputVoltageSolarModule18) {
		this.inputVoltageSolarModule18 = inputVoltageSolarModule18;
	}

	public Double getInputCurrentSolarModule18() {
		return inputCurrentSolarModule18;
	}

	public void setInputCurrentSolarModule18(Double inputCurrentSolarModule18) {
		this.inputCurrentSolarModule18 = inputCurrentSolarModule18;
	}

	public Double getOutputVoltageSolarModule18() {
		return outputVoltageSolarModule18;
	}

	public void setOutputVoltageSolarModule18(Double outputVoltageSolarModule18) {
		this.outputVoltageSolarModule18 = outputVoltageSolarModule18;
	}

	public Double getOutputCurrentSolarModule18() {
		return outputCurrentSolarModule18;
	}

	public void setOutputCurrentSolarModule18(Double outputCurrentSolarModule18) {
		this.outputCurrentSolarModule18 = outputCurrentSolarModule18;
	}

	public String getSolarModule18Status() {
		return solarModule18Status;
	}

	public void setSolarModule18Status(String solarModule18Status) {
		this.solarModule18Status = solarModule18Status;
	}

	public Double getInputVoltageSolarModule19() {
		return inputVoltageSolarModule19;
	}

	public void setInputVoltageSolarModule19(Double inputVoltageSolarModule19) {
		this.inputVoltageSolarModule19 = inputVoltageSolarModule19;
	}

	public Double getInputCurrentSolarModule19() {
		return inputCurrentSolarModule19;
	}

	public void setInputCurrentSolarModule19(Double inputCurrentSolarModule19) {
		this.inputCurrentSolarModule19 = inputCurrentSolarModule19;
	}

	public Double getOutputVoltageSolarModule19() {
		return outputVoltageSolarModule19;
	}

	public void setOutputVoltageSolarModule19(Double outputVoltageSolarModule19) {
		this.outputVoltageSolarModule19 = outputVoltageSolarModule19;
	}

	public Double getOutputCurrentSolarModule19() {
		return outputCurrentSolarModule19;
	}

	public void setOutputCurrentSolarModule19(Double outputCurrentSolarModule19) {
		this.outputCurrentSolarModule19 = outputCurrentSolarModule19;
	}

	public String getSolarModule19Status() {
		return solarModule19Status;
	}

	public void setSolarModule19Status(String solarModule19Status) {
		this.solarModule19Status = solarModule19Status;
	}

	public Double getInputVoltageSolarModule20() {
		return inputVoltageSolarModule20;
	}

	public void setInputVoltageSolarModule20(Double inputVoltageSolarModule20) {
		this.inputVoltageSolarModule20 = inputVoltageSolarModule20;
	}

	public Double getInputCurrentSolarModule20() {
		return inputCurrentSolarModule20;
	}

	public void setInputCurrentSolarModule20(Double inputCurrentSolarModule20) {
		this.inputCurrentSolarModule20 = inputCurrentSolarModule20;
	}

	public Double getOutputVoltageSolarModule20() {
		return outputVoltageSolarModule20;
	}

	public void setOutputVoltageSolarModule20(Double outputVoltageSolarModule20) {
		this.outputVoltageSolarModule20 = outputVoltageSolarModule20;
	}

	public Double getOutputCurrentSolarModule20() {
		return outputCurrentSolarModule20;
	}

	public void setOutputCurrentSolarModule20(Double outputCurrentSolarModule20) {
		this.outputCurrentSolarModule20 = outputCurrentSolarModule20;
	}

	public String getSolarModule20Status() {
		return solarModule20Status;
	}

	public void setSolarModule20Status(String solarModule20Status) {
		this.solarModule20Status = solarModule20Status;
	}

	public Double getInputVoltageSolarModule21() {
		return inputVoltageSolarModule21;
	}

	public void setInputVoltageSolarModule21(Double inputVoltageSolarModule21) {
		this.inputVoltageSolarModule21 = inputVoltageSolarModule21;
	}

	public Double getInputCurrentSolarModule21() {
		return inputCurrentSolarModule21;
	}

	public void setInputCurrentSolarModule21(Double inputCurrentSolarModule21) {
		this.inputCurrentSolarModule21 = inputCurrentSolarModule21;
	}

	public Double getOutputVoltageSolarModule21() {
		return outputVoltageSolarModule21;
	}

	public void setOutputVoltageSolarModule21(Double outputVoltageSolarModule21) {
		this.outputVoltageSolarModule21 = outputVoltageSolarModule21;
	}

	public Double getOutputCurrentSolarModule21() {
		return outputCurrentSolarModule21;
	}

	public void setOutputCurrentSolarModule21(Double outputCurrentSolarModule21) {
		this.outputCurrentSolarModule21 = outputCurrentSolarModule21;
	}

	public String getSolarModule21Status() {
		return solarModule21Status;
	}

	public void setSolarModule21Status(String solarModule21Status) {
		this.solarModule21Status = solarModule21Status;
	}

	public Double getInputVoltageSolarModule22() {
		return inputVoltageSolarModule22;
	}

	public void setInputVoltageSolarModule22(Double inputVoltageSolarModule22) {
		this.inputVoltageSolarModule22 = inputVoltageSolarModule22;
	}

	public Double getInputCurrentSolarModule22() {
		return inputCurrentSolarModule22;
	}

	public void setInputCurrentSolarModule22(Double inputCurrentSolarModule22) {
		this.inputCurrentSolarModule22 = inputCurrentSolarModule22;
	}

	public Double getOutputVoltageSolarModule22() {
		return outputVoltageSolarModule22;
	}

	public void setOutputVoltageSolarModule22(Double outputVoltageSolarModule22) {
		this.outputVoltageSolarModule22 = outputVoltageSolarModule22;
	}

	public Double getOutputCurrentSolarModule22() {
		return outputCurrentSolarModule22;
	}

	public void setOutputCurrentSolarModule22(Double outputCurrentSolarModule22) {
		this.outputCurrentSolarModule22 = outputCurrentSolarModule22;
	}

	public String getSolarModule22Status() {
		return solarModule22Status;
	}

	public void setSolarModule22Status(String solarModule22Status) {
		this.solarModule22Status = solarModule22Status;
	}

	public Double getInputVoltageSolarModule23() {
		return inputVoltageSolarModule23;
	}

	public void setInputVoltageSolarModule23(Double inputVoltageSolarModule23) {
		this.inputVoltageSolarModule23 = inputVoltageSolarModule23;
	}

	public Double getInputCurrentSolarModule23() {
		return inputCurrentSolarModule23;
	}

	public void setInputCurrentSolarModule23(Double inputCurrentSolarModule23) {
		this.inputCurrentSolarModule23 = inputCurrentSolarModule23;
	}

	public Double getOutputVoltageSolarModule23() {
		return outputVoltageSolarModule23;
	}

	public void setOutputVoltageSolarModule23(Double outputVoltageSolarModule23) {
		this.outputVoltageSolarModule23 = outputVoltageSolarModule23;
	}

	public Double getOutputCurrentSolarModule23() {
		return outputCurrentSolarModule23;
	}

	public void setOutputCurrentSolarModule23(Double outputCurrentSolarModule23) {
		this.outputCurrentSolarModule23 = outputCurrentSolarModule23;
	}

	public String getSolarModule23Status() {
		return solarModule23Status;
	}

	public void setSolarModule23Status(String solarModule23Status) {
		this.solarModule23Status = solarModule23Status;
	}

	public Double getInputVoltageSolarModule24() {
		return inputVoltageSolarModule24;
	}

	public void setInputVoltageSolarModule24(Double inputVoltageSolarModule24) {
		this.inputVoltageSolarModule24 = inputVoltageSolarModule24;
	}

	public Double getInputCurrentSolarModule24() {
		return inputCurrentSolarModule24;
	}

	public void setInputCurrentSolarModule24(Double inputCurrentSolarModule24) {
		this.inputCurrentSolarModule24 = inputCurrentSolarModule24;
	}

	public Double getOutputVoltageSolarModule24() {
		return outputVoltageSolarModule24;
	}

	public void setOutputVoltageSolarModule24(Double outputVoltageSolarModule24) {
		this.outputVoltageSolarModule24 = outputVoltageSolarModule24;
	}

	public Double getOutputCurrentSolarModule24() {
		return outputCurrentSolarModule24;
	}

	public void setOutputCurrentSolarModule24(Double outputCurrentSolarModule24) {
		this.outputCurrentSolarModule24 = outputCurrentSolarModule24;
	}

	public String getSolarModule24Status() {
		return solarModule24Status;
	}

	public void setSolarModule24Status(String solarModule24Status) {
		this.solarModule24Status = solarModule24Status;
	}

	public Integer getNumberOfSolarModule() {
		return numberOfSolarModule;
	}

	public void setNumberOfSolarModule(Integer numberOfSolarModule) {
		this.numberOfSolarModule = numberOfSolarModule;
	}

	public Double getSolarInputEnergy() {
		return solarInputEnergy;
	}

	public void setSolarInputEnergy(Double solarInputEnergy) {
		this.solarInputEnergy = solarInputEnergy;
	}

	public Double getSolarOutputEnergy() {
		return solarOutputEnergy;
	}

	public void setSolarOutputEnergy(Double solarOutputEnergy) {
		this.solarOutputEnergy = solarOutputEnergy;
	}

	public Double getSolarRunHours() {
		return solarRunHours;
	}

	public void setSolarRunHours(Double solarRunHours) {
		this.solarRunHours = solarRunHours;
	}

	public Double getSolarMDGRunHours() {
		return solarMDGRunHours;
	}

	public void setSolarMDGRunHours(Double solarMDGRunHours) {
		this.solarMDGRunHours = solarMDGRunHours;
	}

	public Double getSolarDGRunHours() {
		return solarDGRunHours;
	}

	public void setSolarDGRunHours(Double solarDGRunHours) {
		this.solarDGRunHours = solarDGRunHours;
	}

	public Double getSolarBatteryRunHours() {
		return solarBatteryRunHours;
	}

	public void setSolarBatteryRunHours(Double solarBatteryRunHours) {
		this.solarBatteryRunHours = solarBatteryRunHours;
	}

	public Double getSolarTotalInputPower() {
		return solarTotalInputPower;
	}

	public void setSolarTotalInputPower(Double solarTotalInputPower) {
		this.solarTotalInputPower = solarTotalInputPower;
	}

	public Double getSolarTotalOutputPower() {
		return solarTotalOutputPower;
	}

	public void setSolarTotalOutputPower(Double solarTotalOutputPower) {
		this.solarTotalOutputPower = solarTotalOutputPower;
	}

	public String getSysOutLoadStatus() {
		return sysOutLoadStatus;
	}

	public void setSysOutLoadStatus(String sysOutLoadStatus) {
		this.sysOutLoadStatus = sysOutLoadStatus;
	}

	public Double getMdgRunHour() {
		return mdgRunHour;
	}

	public void setMdgRunHour(Double mdgRunHour) {
		this.mdgRunHour = mdgRunHour;
	}

	public Double getTeleRunHours() {
		return teleRunHours;
	}

	public void setTeleRunHours(Double teleRunHours) {
		this.teleRunHours = teleRunHours;
	}

	public Double getTeleEnergy() {
		return teleEnergy;
	}

	public void setTeleEnergy(Double teleEnergy) {
		this.teleEnergy = teleEnergy;
	}

	public Double getCommunityLoadRVoltage() {
		return communityLoadRVoltage;
	}

	public void setCommunityLoadRVoltage(Double communityLoadRVoltage) {
		this.communityLoadRVoltage = communityLoadRVoltage;
	}

	public Double getCommunityLoadYVoltage() {
		return communityLoadYVoltage;
	}

	public void setCommunityLoadYVoltage(Double communityLoadYVoltage) {
		this.communityLoadYVoltage = communityLoadYVoltage;
	}

	public Double getCommunityLoadBVoltage() {
		return communityLoadBVoltage;
	}

	public void setCommunityLoadBVoltage(Double communityLoadBVoltage) {
		this.communityLoadBVoltage = communityLoadBVoltage;
	}

	public Double getCommunityLoadRCurrent() {
		return communityLoadRCurrent;
	}

	public void setCommunityLoadRCurrent(Double communityLoadRCurrent) {
		this.communityLoadRCurrent = communityLoadRCurrent;
	}

	public Double getCommunityLoadYCurrent() {
		return communityLoadYCurrent;
	}

	public void setCommunityLoadYCurrent(Double communityLoadYCurrent) {
		this.communityLoadYCurrent = communityLoadYCurrent;
	}

	public Double getCommunityLoadBCurrent() {
		return communityLoadBCurrent;
	}

	public void setCommunityLoadBCurrent(Double communityLoadBCurrent) {
		this.communityLoadBCurrent = communityLoadBCurrent;
	}

	public Double getCommunityLoadRPowerFactor() {
		return communityLoadRPowerFactor;
	}

	public void setCommunityLoadRPowerFactor(Double communityLoadRPowerFactor) {
		this.communityLoadRPowerFactor = communityLoadRPowerFactor;
	}

	public Double getCommunityLoadYPowerFactor() {
		return communityLoadYPowerFactor;
	}

	public void setCommunityLoadYPowerFactor(Double communityLoadYPowerFactor) {
		this.communityLoadYPowerFactor = communityLoadYPowerFactor;
	}

	public Double getCommunityLoadBPowerFactor() {
		return communityLoadBPowerFactor;
	}

	public void setCommunityLoadBPowerFactor(Double communityLoadBPowerFactor) {
		this.communityLoadBPowerFactor = communityLoadBPowerFactor;
	}

	public Double getCommunityLoadRPower() {
		return communityLoadRPower;
	}

	public void setCommunityLoadRPower(Double communityLoadRPower) {
		this.communityLoadRPower = communityLoadRPower;
	}

	public Double getCommunityLoadYPower() {
		return communityLoadYPower;
	}

	public void setCommunityLoadYPower(Double communityLoadYPower) {
		this.communityLoadYPower = communityLoadYPower;
	}

	public Double getCommunityLoadBPower() {
		return communityLoadBPower;
	}

	public void setCommunityLoadBPower(Double communityLoadBPower) {
		this.communityLoadBPower = communityLoadBPower;
	}

	public Double getCommunityLoadFrequency() {
		return communityLoadFrequency;
	}

	public void setCommunityLoadFrequency(Double communityLoadFrequency) {
		this.communityLoadFrequency = communityLoadFrequency;
	}

	public Double getCommunityLoadRunHours() {
		return communityLoadRunHours;
	}

	public void setCommunityLoadRunHours(Double communityLoadRunHours) {
		this.communityLoadRunHours = communityLoadRunHours;
	}

	public Double getCommunityLoadEnergy() {
		return communityLoadEnergy;
	}

	public void setCommunityLoadEnergy(Double communityLoadEnergy) {
		this.communityLoadEnergy = communityLoadEnergy;
	}

	public Double getInverterInputVoltage1() {
		return inverterInputVoltage1;
	}

	public void setInverterInputVoltage1(Double inverterInputVoltage1) {
		this.inverterInputVoltage1 = inverterInputVoltage1;
	}

	public Double getInverterInputCurrent1() {
		return inverterInputCurrent1;
	}

	public void setInverterInputCurrent1(Double inverterInputCurrent1) {
		this.inverterInputCurrent1 = inverterInputCurrent1;
	}

	public Double getInverterOutVoltage1() {
		return inverterOutVoltage1;
	}

	public void setInverterOutVoltage1(Double inverterOutVoltage1) {
		this.inverterOutVoltage1 = inverterOutVoltage1;
	}

	public Double getInverterOutputCurrent1() {
		return inverterOutputCurrent1;
	}

	public void setInverterOutputCurrent1(Double inverterOutputCurrent1) {
		this.inverterOutputCurrent1 = inverterOutputCurrent1;
	}

	public Double getInverterOutputEnergy1() {
		return inverterOutputEnergy1;
	}

	public void setInverterOutputEnergy1(Double inverterOutputEnergy1) {
		this.inverterOutputEnergy1 = inverterOutputEnergy1;
	}

	public Double getInverterTemp1() {
		return inverterTemp1;
	}

	public void setInverterTemp1(Double inverterTemp1) {
		this.inverterTemp1 = inverterTemp1;
	}

	public String getIneverterStatus1() {
		return ineverterStatus1;
	}

	public void setIneverterStatus1(String ineverterStatus1) {
		this.ineverterStatus1 = ineverterStatus1;
	}

	public Double getInverterInputVoltage2() {
		return inverterInputVoltage2;
	}

	public void setInverterInputVoltage2(Double inverterInputVoltage2) {
		this.inverterInputVoltage2 = inverterInputVoltage2;
	}

	public Double getInverterInputCurrent2() {
		return inverterInputCurrent2;
	}

	public void setInverterInputCurrent2(Double inverterInputCurrent2) {
		this.inverterInputCurrent2 = inverterInputCurrent2;
	}

	public Double getInverterOutVoltage2() {
		return inverterOutVoltage2;
	}

	public void setInverterOutVoltage2(Double inverterOutVoltage2) {
		this.inverterOutVoltage2 = inverterOutVoltage2;
	}

	public Double getInverterOutputCurrent2() {
		return inverterOutputCurrent2;
	}

	public void setInverterOutputCurrent2(Double inverterOutputCurrent2) {
		this.inverterOutputCurrent2 = inverterOutputCurrent2;
	}

	public Double getInverterOutputEnergy2() {
		return inverterOutputEnergy2;
	}

	public void setInverterOutputEnergy2(Double inverterOutputEnergy2) {
		this.inverterOutputEnergy2 = inverterOutputEnergy2;
	}

	public Double getInverterTemp2() {
		return inverterTemp2;
	}

	public void setInverterTemp2(Double inverterTemp2) {
		this.inverterTemp2 = inverterTemp2;
	}

	public String getIneverterStatus2() {
		return ineverterStatus2;
	}

	public void setIneverterStatus2(String ineverterStatus2) {
		this.ineverterStatus2 = ineverterStatus2;
	}

	public Double getInverterInputVoltage3() {
		return inverterInputVoltage3;
	}

	public void setInverterInputVoltage3(Double inverterInputVoltage3) {
		this.inverterInputVoltage3 = inverterInputVoltage3;
	}

	public Double getInverterInputCurrent3() {
		return inverterInputCurrent3;
	}

	public void setInverterInputCurrent3(Double inverterInputCurrent3) {
		this.inverterInputCurrent3 = inverterInputCurrent3;
	}

	public Double getInverterOutVoltage3() {
		return inverterOutVoltage3;
	}

	public void setInverterOutVoltage3(Double inverterOutVoltage3) {
		this.inverterOutVoltage3 = inverterOutVoltage3;
	}

	public Double getInverterOutputCurrent3() {
		return inverterOutputCurrent3;
	}

	public void setInverterOutputCurrent3(Double inverterOutputCurrent3) {
		this.inverterOutputCurrent3 = inverterOutputCurrent3;
	}

	public Double getInverterOutputEnergy3() {
		return inverterOutputEnergy3;
	}

	public void setInverterOutputEnergy3(Double inverterOutputEnergy3) {
		this.inverterOutputEnergy3 = inverterOutputEnergy3;
	}

	public Double getInverterTemp3() {
		return inverterTemp3;
	}

	public void setInverterTemp3(Double inverterTemp3) {
		this.inverterTemp3 = inverterTemp3;
	}

	public String getIneverterStatus3() {
		return ineverterStatus3;
	}

	public void setIneverterStatus3(String ineverterStatus3) {
		this.ineverterStatus3 = ineverterStatus3;
	}

	public Double getInverterInputVoltage4() {
		return inverterInputVoltage4;
	}

	public void setInverterInputVoltage4(Double inverterInputVoltage4) {
		this.inverterInputVoltage4 = inverterInputVoltage4;
	}

	public Double getInverterInputCurrent4() {
		return inverterInputCurrent4;
	}

	public void setInverterInputCurrent4(Double inverterInputCurrent4) {
		this.inverterInputCurrent4 = inverterInputCurrent4;
	}

	public Double getInverterOutVoltage4() {
		return inverterOutVoltage4;
	}

	public void setInverterOutVoltage4(Double inverterOutVoltage4) {
		this.inverterOutVoltage4 = inverterOutVoltage4;
	}

	public Double getInverterOutputCurrent4() {
		return inverterOutputCurrent4;
	}

	public void setInverterOutputCurrent4(Double inverterOutputCurrent4) {
		this.inverterOutputCurrent4 = inverterOutputCurrent4;
	}

	public Double getInverterOutputEnergy4() {
		return inverterOutputEnergy4;
	}

	public void setInverterOutputEnergy4(Double inverterOutputEnergy4) {
		this.inverterOutputEnergy4 = inverterOutputEnergy4;
	}

	public Double getInverterTemp4() {
		return inverterTemp4;
	}

	public void setInverterTemp4(Double inverterTemp4) {
		this.inverterTemp4 = inverterTemp4;
	}

	public String getIneverterStatus4() {
		return ineverterStatus4;
	}

	public void setIneverterStatus4(String ineverterStatus4) {
		this.ineverterStatus4 = ineverterStatus4;
	}

	public Double getInverterInputVoltage5() {
		return inverterInputVoltage5;
	}

	public void setInverterInputVoltage5(Double inverterInputVoltage5) {
		this.inverterInputVoltage5 = inverterInputVoltage5;
	}

	public Double getInverterInputCurrent5() {
		return inverterInputCurrent5;
	}

	public void setInverterInputCurrent5(Double inverterInputCurrent5) {
		this.inverterInputCurrent5 = inverterInputCurrent5;
	}

	public Double getInverterOutVoltage5() {
		return inverterOutVoltage5;
	}

	public void setInverterOutVoltage5(Double inverterOutVoltage5) {
		this.inverterOutVoltage5 = inverterOutVoltage5;
	}

	public Double getInverterOutputCurrent5() {
		return inverterOutputCurrent5;
	}

	public void setInverterOutputCurrent5(Double inverterOutputCurrent5) {
		this.inverterOutputCurrent5 = inverterOutputCurrent5;
	}

	public Double getInverterOutputEnergy5() {
		return inverterOutputEnergy5;
	}

	public void setInverterOutputEnergy5(Double inverterOutputEnergy5) {
		this.inverterOutputEnergy5 = inverterOutputEnergy5;
	}

	public Double getInverterTemp5() {
		return inverterTemp5;
	}

	public void setInverterTemp5(Double inverterTemp5) {
		this.inverterTemp5 = inverterTemp5;
	}

	public String getIneverterStatus5() {
		return ineverterStatus5;
	}

	public void setIneverterStatus5(String ineverterStatus5) {
		this.ineverterStatus5 = ineverterStatus5;
	}

	public Double getInverterInputVoltage6() {
		return inverterInputVoltage6;
	}

	public void setInverterInputVoltage6(Double inverterInputVoltage6) {
		this.inverterInputVoltage6 = inverterInputVoltage6;
	}

	public Double getInverterInputCurrent6() {
		return inverterInputCurrent6;
	}

	public void setInverterInputCurrent6(Double inverterInputCurrent6) {
		this.inverterInputCurrent6 = inverterInputCurrent6;
	}

	public Double getInverterOutVoltage6() {
		return inverterOutVoltage6;
	}

	public void setInverterOutVoltage6(Double inverterOutVoltage6) {
		this.inverterOutVoltage6 = inverterOutVoltage6;
	}

	public Double getInverterOutputCurrent6() {
		return inverterOutputCurrent6;
	}

	public void setInverterOutputCurrent6(Double inverterOutputCurrent6) {
		this.inverterOutputCurrent6 = inverterOutputCurrent6;
	}

	public Double getInverterOutputEnergy6() {
		return inverterOutputEnergy6;
	}

	public void setInverterOutputEnergy6(Double inverterOutputEnergy6) {
		this.inverterOutputEnergy6 = inverterOutputEnergy6;
	}

	public Double getInverterTemp6() {
		return inverterTemp6;
	}

	public void setInverterTemp6(Double inverterTemp6) {
		this.inverterTemp6 = inverterTemp6;
	}

	public String getIneverterStatus6() {
		return ineverterStatus6;
	}

	public void setIneverterStatus6(String ineverterStatus6) {
		this.ineverterStatus6 = ineverterStatus6;
	}

	public Double getInverterInputVoltage7() {
		return inverterInputVoltage7;
	}

	public void setInverterInputVoltage7(Double inverterInputVoltage7) {
		this.inverterInputVoltage7 = inverterInputVoltage7;
	}

	public Double getInverterInputCurrent7() {
		return inverterInputCurrent7;
	}

	public void setInverterInputCurrent7(Double inverterInputCurrent7) {
		this.inverterInputCurrent7 = inverterInputCurrent7;
	}

	public Double getInverterOutVoltage7() {
		return inverterOutVoltage7;
	}

	public void setInverterOutVoltage7(Double inverterOutVoltage7) {
		this.inverterOutVoltage7 = inverterOutVoltage7;
	}

	public Double getInverterOutputCurrent7() {
		return inverterOutputCurrent7;
	}

	public void setInverterOutputCurrent7(Double inverterOutputCurrent7) {
		this.inverterOutputCurrent7 = inverterOutputCurrent7;
	}

	public Double getInverterOutputEnergy7() {
		return inverterOutputEnergy7;
	}

	public void setInverterOutputEnergy7(Double inverterOutputEnergy7) {
		this.inverterOutputEnergy7 = inverterOutputEnergy7;
	}

	public Double getInverterTemp7() {
		return inverterTemp7;
	}

	public void setInverterTemp7(Double inverterTemp7) {
		this.inverterTemp7 = inverterTemp7;
	}

	public String getIneverterStatus7() {
		return ineverterStatus7;
	}

	public void setIneverterStatus7(String ineverterStatus7) {
		this.ineverterStatus7 = ineverterStatus7;
	}

	public Double getInverterInputVoltage8() {
		return inverterInputVoltage8;
	}

	public void setInverterInputVoltage8(Double inverterInputVoltage8) {
		this.inverterInputVoltage8 = inverterInputVoltage8;
	}

	public Double getInverterInputCurrent8() {
		return inverterInputCurrent8;
	}

	public void setInverterInputCurrent8(Double inverterInputCurrent8) {
		this.inverterInputCurrent8 = inverterInputCurrent8;
	}

	public Double getInverterOutVoltage8() {
		return inverterOutVoltage8;
	}

	public void setInverterOutVoltage8(Double inverterOutVoltage8) {
		this.inverterOutVoltage8 = inverterOutVoltage8;
	}

	public Double getInverterOutputCurrent8() {
		return inverterOutputCurrent8;
	}

	public void setInverterOutputCurrent8(Double inverterOutputCurrent8) {
		this.inverterOutputCurrent8 = inverterOutputCurrent8;
	}

	public Double getInverterOutputEnergy8() {
		return inverterOutputEnergy8;
	}

	public void setInverterOutputEnergy8(Double inverterOutputEnergy8) {
		this.inverterOutputEnergy8 = inverterOutputEnergy8;
	}

	public Double getInverterTemp8() {
		return inverterTemp8;
	}

	public void setInverterTemp8(Double inverterTemp8) {
		this.inverterTemp8 = inverterTemp8;
	}

	public String getIneverterStatus8() {
		return ineverterStatus8;
	}

	public void setIneverterStatus8(String ineverterStatus8) {
		this.ineverterStatus8 = ineverterStatus8;
	}

	public Double getInverterInputVoltage9() {
		return inverterInputVoltage9;
	}

	public void setInverterInputVoltage9(Double inverterInputVoltage9) {
		this.inverterInputVoltage9 = inverterInputVoltage9;
	}

	public Double getInverterInputCurrent9() {
		return inverterInputCurrent9;
	}

	public void setInverterInputCurrent9(Double inverterInputCurrent9) {
		this.inverterInputCurrent9 = inverterInputCurrent9;
	}

	public Double getInverterOutVoltage9() {
		return inverterOutVoltage9;
	}

	public void setInverterOutVoltage9(Double inverterOutVoltage9) {
		this.inverterOutVoltage9 = inverterOutVoltage9;
	}

	public Double getInverterOutputCurrent9() {
		return inverterOutputCurrent9;
	}

	public void setInverterOutputCurrent9(Double inverterOutputCurrent9) {
		this.inverterOutputCurrent9 = inverterOutputCurrent9;
	}

	public Double getInverterOutputEnergy9() {
		return inverterOutputEnergy9;
	}

	public void setInverterOutputEnergy9(Double inverterOutputEnergy9) {
		this.inverterOutputEnergy9 = inverterOutputEnergy9;
	}

	public Double getInverterTemp9() {
		return inverterTemp9;
	}

	public void setInverterTemp9(Double inverterTemp9) {
		this.inverterTemp9 = inverterTemp9;
	}

	public String getIneverterStatus9() {
		return ineverterStatus9;
	}

	public void setIneverterStatus9(String ineverterStatus9) {
		this.ineverterStatus9 = ineverterStatus9;
	}

	public Double getInverterInputVoltage10() {
		return inverterInputVoltage10;
	}

	public void setInverterInputVoltage10(Double inverterInputVoltage10) {
		this.inverterInputVoltage10 = inverterInputVoltage10;
	}

	public Double getInverterInputCurrent10() {
		return inverterInputCurrent10;
	}

	public void setInverterInputCurrent10(Double inverterInputCurrent10) {
		this.inverterInputCurrent10 = inverterInputCurrent10;
	}

	public Double getInverterOutVoltage10() {
		return inverterOutVoltage10;
	}

	public void setInverterOutVoltage10(Double inverterOutVoltage10) {
		this.inverterOutVoltage10 = inverterOutVoltage10;
	}

	public Double getInverterOutputCurrent10() {
		return inverterOutputCurrent10;
	}

	public void setInverterOutputCurrent10(Double inverterOutputCurrent10) {
		this.inverterOutputCurrent10 = inverterOutputCurrent10;
	}

	public Double getInverterOutputEnergy10() {
		return inverterOutputEnergy10;
	}

	public void setInverterOutputEnergy10(Double inverterOutputEnergy10) {
		this.inverterOutputEnergy10 = inverterOutputEnergy10;
	}

	public Double getInverterTemp10() {
		return inverterTemp10;
	}

	public void setInverterTemp10(Double inverterTemp10) {
		this.inverterTemp10 = inverterTemp10;
	}

	public String getIneverterStatus10() {
		return ineverterStatus10;
	}

	public void setIneverterStatus10(String ineverterStatus10) {
		this.ineverterStatus10 = ineverterStatus10;
	}

	public Double getInverterInputVoltage11() {
		return inverterInputVoltage11;
	}

	public void setInverterInputVoltage11(Double inverterInputVoltage11) {
		this.inverterInputVoltage11 = inverterInputVoltage11;
	}

	public Double getInverterInputCurrent11() {
		return inverterInputCurrent11;
	}

	public void setInverterInputCurrent11(Double inverterInputCurrent11) {
		this.inverterInputCurrent11 = inverterInputCurrent11;
	}

	public Double getInverterOutVoltage11() {
		return inverterOutVoltage11;
	}

	public void setInverterOutVoltage11(Double inverterOutVoltage11) {
		this.inverterOutVoltage11 = inverterOutVoltage11;
	}

	public Double getInverterOutputCurrent11() {
		return inverterOutputCurrent11;
	}

	public void setInverterOutputCurrent11(Double inverterOutputCurrent11) {
		this.inverterOutputCurrent11 = inverterOutputCurrent11;
	}

	public Double getInverterOutputEnergy11() {
		return inverterOutputEnergy11;
	}

	public void setInverterOutputEnergy11(Double inverterOutputEnergy11) {
		this.inverterOutputEnergy11 = inverterOutputEnergy11;
	}

	public Double getInverterTemp11() {
		return inverterTemp11;
	}

	public void setInverterTemp11(Double inverterTemp11) {
		this.inverterTemp11 = inverterTemp11;
	}

	public String getIneverterStatus11() {
		return ineverterStatus11;
	}

	public void setIneverterStatus11(String ineverterStatus11) {
		this.ineverterStatus11 = ineverterStatus11;
	}

	public Double getInverterInputVoltage12() {
		return inverterInputVoltage12;
	}

	public void setInverterInputVoltage12(Double inverterInputVoltage12) {
		this.inverterInputVoltage12 = inverterInputVoltage12;
	}

	public Double getInverterInputCurrent12() {
		return inverterInputCurrent12;
	}

	public void setInverterInputCurrent12(Double inverterInputCurrent12) {
		this.inverterInputCurrent12 = inverterInputCurrent12;
	}

	public Double getInverterOutVoltage12() {
		return inverterOutVoltage12;
	}

	public void setInverterOutVoltage12(Double inverterOutVoltage12) {
		this.inverterOutVoltage12 = inverterOutVoltage12;
	}

	public Double getInverterOutputCurrent12() {
		return inverterOutputCurrent12;
	}

	public void setInverterOutputCurrent12(Double inverterOutputCurrent12) {
		this.inverterOutputCurrent12 = inverterOutputCurrent12;
	}

	public Double getInverterOutputEnergy12() {
		return inverterOutputEnergy12;
	}

	public void setInverterOutputEnergy12(Double inverterOutputEnergy12) {
		this.inverterOutputEnergy12 = inverterOutputEnergy12;
	}

	public Double getInverterTemp12() {
		return inverterTemp12;
	}

	public void setInverterTemp12(Double inverterTemp12) {
		this.inverterTemp12 = inverterTemp12;
	}

	public String getIneverterStatus12() {
		return ineverterStatus12;
	}

	public void setIneverterStatus12(String ineverterStatus12) {
		this.ineverterStatus12 = ineverterStatus12;
	}

	public Integer getNumberOfInverter() {
		return numberOfInverter;
	}

	public void setNumberOfInverter(Integer numberOfInverter) {
		this.numberOfInverter = numberOfInverter;
	}

	public Double getInverterRunHours() {
		return inverterRunHours;
	}

	public void setInverterRunHours(Double inverterRunHours) {
		this.inverterRunHours = inverterRunHours;
	}

	public Double getInverterEnergy() {
		return inverterEnergy;
	}

	public void setInverterEnergy(Double inverterEnergy) {
		this.inverterEnergy = inverterEnergy;
	}

	public Double getInverterInputPower() {
		return inverterInputPower;
	}

	public void setInverterInputPower(Double inverterInputPower) {
		this.inverterInputPower = inverterInputPower;
	}

	public Double getInverterOutputPower() {
		return inverterOutputPower;
	}

	public void setInverterOutputPower(Double inverterOutputPower) {
		this.inverterOutputPower = inverterOutputPower;
	}

	public Double getActelRVoltage() {
		return actelRVoltage;
	}

	public void setActelRVoltage(Double actelRVoltage) {
		this.actelRVoltage = actelRVoltage;
	}

	public Double getActelYVoltage() {
		return actelYVoltage;
	}

	public void setActelYVoltage(Double actelYVoltage) {
		this.actelYVoltage = actelYVoltage;
	}

	public Double getActelBVoltage() {
		return actelBVoltage;
	}

	public void setActelBVoltage(Double actelBVoltage) {
		this.actelBVoltage = actelBVoltage;
	}

	public Double getActelRCurrent() {
		return actelRCurrent;
	}

	public void setActelRCurrent(Double actelRCurrent) {
		this.actelRCurrent = actelRCurrent;
	}

	public Double getActelYCurrent() {
		return actelYCurrent;
	}

	public void setActelYCurrent(Double actelYCurrent) {
		this.actelYCurrent = actelYCurrent;
	}

	public Double getActelBCurrent() {
		return actelBCurrent;
	}

	public void setActelBCurrent(Double actelBCurrent) {
		this.actelBCurrent = actelBCurrent;
	}

	public Double getActelRPowerFactor() {
		return actelRPowerFactor;
	}

	public void setActelRPowerFactor(Double actelRPowerFactor) {
		this.actelRPowerFactor = actelRPowerFactor;
	}

	public Double getActelYPowerFactor() {
		return actelYPowerFactor;
	}

	public void setActelYPowerFactor(Double actelYPowerFactor) {
		this.actelYPowerFactor = actelYPowerFactor;
	}

	public Double getActelBPowerFactor() {
		return actelBPowerFactor;
	}

	public void setActelBPowerFactor(Double actelBPowerFactor) {
		this.actelBPowerFactor = actelBPowerFactor;
	}

	public Double getActelRPower() {
		return actelRPower;
	}

	public void setActelRPower(Double actelRPower) {
		this.actelRPower = actelRPower;
	}

	public Double getActelYPower() {
		return actelYPower;
	}

	public void setActelYPower(Double actelYPower) {
		this.actelYPower = actelYPower;
	}

	public Double getActelBPower() {
		return actelBPower;
	}

	public void setActelBPower(Double actelBPower) {
		this.actelBPower = actelBPower;
	}

	public Double getActelFrequency() {
		return actelFrequency;
	}

	public void setActelFrequency(Double actelFrequency) {
		this.actelFrequency = actelFrequency;
	}
}
