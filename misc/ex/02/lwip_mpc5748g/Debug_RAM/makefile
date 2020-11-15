################################################################################
# Automatically-generated file. Do not edit!
################################################################################

-include ../makefile.init

RM := rm -rf

# All of the sources participating in the build are defined here
-include sources.mk
-include Sources/subdir.mk
-include SDK/rtos/osif/subdir.mk
-include SDK/platform/drivers/src/pins/siul2/subdir.mk
-include SDK/platform/drivers/src/interrupt/subdir.mk
-include SDK/platform/drivers/src/enet/subdir.mk
-include SDK/platform/drivers/src/clock/MPC57xx/subdir.mk
-include SDK/platform/devices/MPC5748G/startup/subdir.mk
-include SDK/platform/devices/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/ports/platform/MPC5748G/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/ports/netif/enetif/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/ports/OS/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/demo/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/apps/snmp_private_mib/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/apps/smtp/subdir.mk
-include SDK/middleware/tcpip/tcpip_stack/addons/tcp_isn/subdir.mk
-include SDK/middleware/tcpip/lwip/src/netif/ppp/polarssl/subdir.mk
-include SDK/middleware/tcpip/lwip/src/netif/ppp/subdir.mk
-include SDK/middleware/tcpip/lwip/src/netif/subdir.mk
-include SDK/middleware/tcpip/lwip/src/core/ipv4/subdir.mk
-include SDK/middleware/tcpip/lwip/src/core/subdir.mk
-include SDK/middleware/tcpip/lwip/src/apps/tftp/subdir.mk
-include SDK/middleware/tcpip/lwip/src/apps/snmp/subdir.mk
-include SDK/middleware/tcpip/lwip/src/apps/mqtt/subdir.mk
-include SDK/middleware/tcpip/lwip/src/apps/mdns/subdir.mk
-include Project_Settings/Startup_Code/subdir.mk
-include Project_Settings/Linker_Files/subdir.mk
-include Generated_Code/subdir.mk
-include subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
endif

-include ../makefile.defs

# Add inputs and outputs from these tool invocations to the build variables 
SECONDARY_SIZE += \
lwip_mpc5748g.siz \


# All Target
all: lwip_mpc5748g.elf secondary-outputs

# Tool invocations
lwip_mpc5748g.elf: $(OBJS) C:\NXP\S32DS_Power_v2.1\S32DS\software\S32_SDK_S32PA_RTM_3.0.0\platform\devices\MPC5748G\linker\gcc\MPC5748G_Z4_0\MPC5748G_ram.ld $(OSPT) $(USER_OBJS)
	@echo 'Building target: $@'
	@echo 'Invoking: Standard S32DS C Linker'
	powerpc-eabivle-gcc -o "lwip_mpc5748g.elf" "@lwip_mpc5748g.args"  $(USER_OBJS) $(LIBS) $(OSPT)
	@echo 'Finished building target: $@'
	@echo ' '

lwip_mpc5748g.siz: lwip_mpc5748g.elf
	@echo 'Invoking: Standard S32DS Print Size'
	powerpc-eabivle-size --format=berkeley lwip_mpc5748g.elf
	@echo 'Finished building: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) ./*
	-@echo ' '

secondary-outputs: $(SECONDARY_SIZE)

.PHONY: all clean dependents

-include ../makefile.targets
