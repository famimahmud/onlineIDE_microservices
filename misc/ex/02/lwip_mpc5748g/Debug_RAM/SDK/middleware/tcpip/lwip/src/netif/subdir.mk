################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ethernet.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ethernetif.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/lowpan6.c \
C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/slipif.c 

OBJS += \
./SDK/middleware/tcpip/lwip/src/netif/ethernet.o \
./SDK/middleware/tcpip/lwip/src/netif/ethernetif.o \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6.o \
./SDK/middleware/tcpip/lwip/src/netif/slipif.o 

C_DEPS += \
./SDK/middleware/tcpip/lwip/src/netif/ethernet.d \
./SDK/middleware/tcpip/lwip/src/netif/ethernetif.d \
./SDK/middleware/tcpip/lwip/src/netif/lowpan6.d \
./SDK/middleware/tcpip/lwip/src/netif/slipif.d 


# Each subdirectory must supply rules for building sources it contributes
SDK/middleware/tcpip/lwip/src/netif/ethernet.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ethernet.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ethernet.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/ethernetif.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/ethernetif.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/ethernetif.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/lowpan6.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/lowpan6.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/lowpan6.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '

SDK/middleware/tcpip/lwip/src/netif/slipif.o: C:/NXP/S32DS_Power_v2.1/S32DS/software/S32_SDK_S32PA_RTM_3.0.0/middleware/tcpip/lwip/src/netif/slipif.c
	@echo 'Building file: $<'
	@echo 'Invoking: Standard S32DS C Compiler'
	powerpc-eabivle-gcc "@SDK/middleware/tcpip/lwip/src/netif/slipif.args" -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


