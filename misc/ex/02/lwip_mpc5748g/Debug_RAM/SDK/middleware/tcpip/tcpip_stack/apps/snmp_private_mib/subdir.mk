################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.c 

OBJS += \
./SDK/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.o 

C_DEPS += \
./SDK/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.d 


# Each subdirectory must supply rules for building sources it contributes
SDK/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/lwip_prvmib.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


